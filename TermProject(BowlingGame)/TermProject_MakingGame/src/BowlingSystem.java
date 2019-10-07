/*****************************************************************************
20166282 Chung-AngUniversity Computer Engineering major 4th grade TaeseongYang		  
Software Project - Term-Project(Making Bowling Game)
2019/06/09 (Sunday)	
******************************************************************************/

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class BowlingSystem
{
    
	
    //Takes in the player name and prints out a personalized welcome letter
    
    public void welcomeMessage() {
        System.out.println(String.format("Welcome to Bowling game"));
    }
    
    
    //Prints the menu options
    
    public void mainMenu() {
        System.out.println("1. Enter a player name\n2. Begin bowling\n3. Quit");
        System.out.println("Enter a number between 1-3:");
    }
    
    
    //Prints out player information: the number of players and their names
    
    public void printPlayerInfo(List<Player> playerList) {
        System.out.println("There are " + playerList.size() + " players in the game.");
        System.out.println("The players are:");
        for (Player player:playerList) {
           System.out.println(player.getName());
       }
    } 
    
    
    /*
    * The system for bowling frames 1-9
    * 
    * Bonus points are calculated using bonusCounter. BonusCounter is incremented by 2 for every strike
    * and 1 for every spare. It is decremented by 1 for each bonus score added. If there are two bonus
    * scores added (e.g. the two previous balls were strikes) then the bonus score is decremented by 2. 
    */
    public void bowlFrame(Player player, int frame) throws IOException {
        int totalScore = 0;
        int bonusCounter = player.checkBonusCounter();
        System.out.println("\n[" + player.getName() + "'s " + (frame + 1) + "th turn]");
        
        // Bowl first round
        int score = getScore(totalScore, player.checkLevel());
        totalScore = totalScore + score;
        player.setFirstBall(frame, score);
        
        // Update player score
        if (bonusCounter == 1 | bonusCounter == 2) {
            player.setPlayerScore(score + score);
            bonusCounter -= 1;
        }
        else if (bonusCounter == 3) {
            player.setPlayerScore(score + score + score);
            bonusCounter -= 2;
        }
        else {
            player.setPlayerScore(score);
        }
        
        if (totalScore == 10){ // Checks for strike 
            player.setSecondball(frame, 0);
            System.out.println("You have bowled a strike!!");
        }
        else {
        	System.out.println("The first ball : " + player.checkFirstBall(frame)); // Gets score for ball 2 if there was no strike
            score = getScore(totalScore, player.checkLevel());
            player.setSecondball(frame, score);
            
            if (bonusCounter == 1) {
                player.setPlayerScore(score + score);
                bonusCounter -= 1;
            }
            
            else {
                player.setPlayerScore(score);
            }
            
            totalScore = totalScore + score;
            
            if (totalScore == 10) { // Checks for spare
            	System.out.println("The second ball : " + player.checkSecondBall(frame));
                System.out.println("You have bowled a spare!!");
            }
            else
            	System.out.println("The second ball : " + player.checkSecondBall(frame));
        }
        
        if ((player.checkFirstBall(frame)) == 10) { // Updates bonus counter if the player got a strike
            bonusCounter += 2;
        }
        else if (totalScore == 10) { // Updates bonus counter if the player got a spare
            bonusCounter += 1;
        }
        player.setBonusCounter(bonusCounter);
        System.out.println(player.getName() + "'s total score is " + player.checkPlayerScore());
        player.setFrameTotal(player.checkPlayerScore());
    } 
    
    
    /*
    * Special system for scoring the last frame.
    * Includes bonus ball if the player got a strike or spare.
    */
    public void bowlLastFrame(Player player, int frame) throws IOException {
        int totalScore = 0;
        int bonusCounter = player.checkBonusCounter();
        System.out.println("\n[" + player.getName() + "'s " + (frame + 1) + "th turn]");
  
        
        // Bowl first ball
  
        int score = getScore(totalScore, player.checkLevel());
        totalScore = totalScore + score;
        player.setFirstBall(frame, score);
        
        // Update player score
        
        if (bonusCounter == 1 | bonusCounter == 2) {
            player.setPlayerScore(score + score);
            bonusCounter -= 1;
        }
        if (bonusCounter == 3) {
            player.setPlayerScore(score + score + score);
            bonusCounter -= 2;
        }
        else {
            player.setPlayerScore(score);
        }

        
        // Bowl second ball - system for when player bowled a strike on the first ball
        
        if (totalScore == 10){ 
            System.out.println("You have bowled a strike!!");
            bonusCounter += 2;
            score = getBonusScore(totalScore);
            totalScore = totalScore + score;
            player.setSecondball(frame, score);
            if (bonusCounter == 1 | bonusCounter == 2) {
                player.setPlayerScore(score);
                bonusCounter -= 1;
            }
            if (bonusCounter == 3) {
                player.setPlayerScore(score + score);
                bonusCounter -= 2;
            }
        }
        
        // Bowl second ball - system for when player did not bowl a strike on the first ball
        
        else {
        	System.out.println("The first ball : " + player.checkFirstBall(frame));
            score = getScore(totalScore, player.checkLevel());
            player.setSecondball(frame, score);
            totalScore = totalScore + score;
            if (bonusCounter == 1 | bonusCounter == 2) {
                player.setPlayerScore(score + score);
                bonusCounter -= 1;
            }
            else {
                player.setPlayerScore(score);
            }
        }
        
        
        // Bowl bonus bowl if player bowled any strikes or a spare this frame  
        
        if (totalScore > 9) {
        	System.out.println("The second ball : " + player.checkSecondBall(frame));
            score = getBonusScore(totalScore);
            player.setBonusBall(score);
            System.out.println("The third ball : " + player.checkBonusBall());
            player.setPlayerScore(score);
        }
        else
        	System.out.println("The second ball : " + player.checkSecondBall(frame));
        
        System.out.println(player.getName() + "'s total score is " + player.checkPlayerScore());
        player.setFrameTotal(player.checkPlayerScore());

    }
    
    
    
    // Gets the bowling score from the player
    
    public int getScore(int totalScore, int level) throws IOException{
    	Random random = new Random();
    	boolean validScore = false;
        int tempScore = 0;
        while (validScore == false) {
        	switch(level) {
        	case 1: tempScore = random.nextInt(11);
        			break;
        	case 2: 
        		if(random.nextInt(10) < 5) tempScore = 10;
        		else if(random.nextInt(10) < 3) tempScore = 9;
        		else if(random.nextInt(10) < 2) tempScore = 8;
        		else tempScore = random.nextInt(11);
        		break;
        	case 3:
        		if(random.nextInt(10) < 7) tempScore = 10;
        		else if(random.nextInt(10) < 2) tempScore = 9;
        		else if(random.nextInt(10) < 1) tempScore = 8;
        		else tempScore = random.nextInt(11);
        	}
        
            if ((tempScore < 0) | (tempScore + totalScore > 10) ){}
            else {
                validScore = true;
            }            
        }
        return tempScore;
    } 
    
    
    
    // Gets the bowling scores for the bonus round
    
    public int getBonusScore(int totalScore) throws IOException{
    	
    	Random random = new Random();
    	
    	boolean validScore = false;
        int tempScore = 0;
       
        while (validScore == false) {
        	
        	tempScore = random.nextInt(11);
            
            if ((tempScore < 0) | (tempScore + totalScore > 20) ){}
            else {
                validScore = true;
            }            
        }
        return tempScore;      
    } 
}
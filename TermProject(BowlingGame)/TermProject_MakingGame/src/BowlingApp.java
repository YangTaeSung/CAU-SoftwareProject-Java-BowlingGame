/*****************************************************************************
20166282 Chung-AngUniversity Computer Engineering major 4th grade TaeseongYang		  
Software Project - Term-Project(Making Bowling Game)
2019/06/09 (Sunday)	
******************************************************************************/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class BowlingApp
{

    public static void main(String[] args) throws IOException {
        
        // Make list of players, Save two player's name and level   
    	
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	
        final BowlingSystem bowlingSystem = new BowlingSystem();
        List<Player> playerList = new ArrayList<Player>(); // A list of players
        
        String name;
        int level;
        
        System.out.print("Please enter the first player's name -> ");
        name = bf.readLine();
        System.out.println("Please enter the first player's level");
        System.out.println("<level1 : 100(avg),  level2 : 150(avg),  level3 : 200(avg)>");
        System.out.print("-> ");
        level = Integer.parseInt(bf.readLine());
        playerList.add(new Player(name,level));
        
        
        System.out.print("Please enter the second player's name -> ");
        name = bf.readLine();
        System.out.println("Please enter the secend player's level");
        System.out.println("<level1 : 100(avg),  level2 : 150(avg),  level3 : 200(avg)>");
        System.out.print("-> ");
        level = Integer.parseInt(bf.readLine());
        playerList.add(new Player(name,level));
        
        
        bowlingSystem.welcomeMessage(); // Prints welcome letter
        bowlingSystem.printPlayerInfo(playerList); // Prints player information 
        
       
        // The game start
        // The final frame is executed separately because of special scoring requirements.
        
        for (int i=0; i<9; i++) {
            for (Player player:playerList) {
                bowlingSystem.bowlFrame(player, i);
            }
        }
        
        
        // Play final frame
        
        for (Player player:playerList) {
            bowlingSystem.bowlLastFrame(player, 9);
        }
        
        
        //Prints the final scoreboard
        
        final ScoreBoard scoreboard = new ScoreBoard();
        scoreboard.printScores(playerList);
    }

}
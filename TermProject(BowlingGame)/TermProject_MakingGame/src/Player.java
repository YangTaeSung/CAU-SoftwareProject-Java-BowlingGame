/*****************************************************************************
20166282 Chung-AngUniversity Computer Engineering major 4th grade TaeseongYang		  
Software Project - Term-Project(Making Bowling Game)
2019/06/09 (Sunday)	
******************************************************************************/


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String _playerName;	
    private int _level;
    private List<Integer> _firstBall = new ArrayList<Integer>();
    private List<Integer> _secondBall = new ArrayList<Integer>();
    private List<Integer> _frameTotal = new ArrayList<Integer>();	// Total score for each frames
    private int _bonusBall;	// Last frame's bonus ball
    private int _playerScore; // Player's Total Score
    private int _bonusCounter; // For bonus score calculation of Strike or Spare
    
    // Sets player name
    public Player(String name){
        _playerName = name;
    }
    
    // Sets player name, level
    public Player(String name, int level){
        _playerName = name;
        _level = level;
    }

    // Gets player name
    public String getName(){
        return _playerName;
    }
    
    // Gets player level
    public int checkLevel() {
    	return _level;
    }
    
    // Sets the first ball of a frame
    public void setFirstBall(int frame, int score) throws IOException{
        _firstBall.add(score);
    }
    
    // Gets the first ball of a frame
    public int checkFirstBall(int frame) {
        return _firstBall.get(frame);
    }
    
    // Sets the second ball of a frame
    public void setSecondball(int frame, int score) throws IOException{
        _secondBall.add(score);
    }
    
    // Gets the second ball of a frame
    public int checkSecondBall(int frame) {
        return _secondBall.get(frame);
    }
    
    // Sets the bonus balls for the last frame
    public void setBonusBall(int score) {
        _bonusBall = score;
    }
    
    // Gets the bonus ball of the last frame
    public int checkBonusBall() {
        return _bonusBall;
    }
    
    // Sets the frame total score 
    public void setFrameTotal(int total) {
    	_frameTotal.add(total);
    }
    
    // Gets the frame total score
    public int checkFrameTotal(int frame) {
    	return _frameTotal.get(frame);
    }
    
    // Updates the player's total score
    public void setPlayerScore(int score) {
        _playerScore = _playerScore + score;
    }
    
    // Gets a player's total score
    public int checkPlayerScore() {
        return _playerScore;
    }

    // Sets a player's bonus counter
    public void setBonusCounter(int bonusCounter) {
        _bonusCounter = bonusCounter;
    }
    
    // Gets a player's bonus counter
    public int checkBonusCounter() {
        return _bonusCounter;
    }
}
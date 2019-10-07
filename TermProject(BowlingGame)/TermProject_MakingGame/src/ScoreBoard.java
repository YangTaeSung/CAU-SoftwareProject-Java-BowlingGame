/*****************************************************************************
20166282 Chung-AngUniversity Computer Engineering major 4th grade TaeseongYang		  
Software Project - Term-Project(Making Bowling Game)
2019/06/09 (Sunday)	
******************************************************************************/


import java.io.IOException;
import java.util.List;

public class ScoreBoard
{
    public void printScores(List<Player> playerList) throws IOException {
      
    	System.out.println("\n********** Output the final scores ********\n");
    	
        for (Player player:playerList) {
            System.out.println(player.getName() + "'s total score is: " + player.checkPlayerScore());
            System.out.println("___________________________________________");
            System.out.print("|");
            
         // print first 9 frames
            
            for (int i = 0; i < 9; i ++){
                if (player.checkFirstBall(i) == 10) {
                    System.out.print("X|");
                }
                else System.out.print(player.checkFirstBall(i) + "|");
                if (player.checkSecondBall(i) == 0) {
                    System.out.print(" |");
                }
                else if ((player.checkFirstBall(i) + player.checkSecondBall(i)) == 10) {
                    System.out.print("/|");
                }
                else {
                    System.out.print(player.checkSecondBall(i) + "|");
                }
                
            } 
            
            
         // print second 10 frame
            
            if (player.checkFirstBall(9) == 10) {
                System.out.print("X|");
            }
            else System.out.print(player.checkFirstBall(9) + "|");
            if (player.checkSecondBall(9) == 10) {
                System.out.print("X|");
            }
            else if ((player.checkFirstBall(9) + player.checkSecondBall(9)) == 10) {
                System.out.print("/|");
            }
            else {
                System.out.print(player.checkSecondBall(9) + "|");
            }
            
            if ((player.checkFirstBall(9) == 10) | (player.checkFirstBall(9) + player.checkSecondBall(9) == 10)) {
                if (player.checkBonusBall() == 10) {
                    System.out.println("X|");
                }
                else {
                    System.out.println(player.checkBonusBall() + "|");
                }
            }
            else {
                System.out.println(" |");
            } 
 
//          for(int i = 0; i < 10; i++)
//          	System.out.print("|_" + player.checkFrameTotal(i) + "_|");
//          System.out.println("\n");
            
            
            System.out.println("|___|___|___|___|___|___|___|___|___|_____|");
            System.out.println("\n");
            
//            ���� �������� ����� "|___|___|" �̷� ������ ��ġ�� ������ �� �������� ��������� ���������ǿ� ���� ��쿡
//            ��µ� ȭ���� ������� �ʾƼ��Դϴ�. �� �������� ������ �ֿܼ��� �� ������� ���ʸ� �����ִ� �κп��� ��µǵ��� �߽��ϴ�. 
            

        } 
    }
}
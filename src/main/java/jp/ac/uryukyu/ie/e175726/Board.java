package jp.ac.uryukyu.ie.e175726;

public class Board {
    private String[][] board = new String[8][8];

    public Board(){
        for(int height = 0;height < 8;height++){
            for(int width = 0;width < 8;width++){
                board [height][width]="　";
            }
        }
    }

    public void Showboard(){
        System.out.println("　１２３４５６７８");
        for(int height = 0;height < 8;height++){
            System.out.print(height+1);
            for(int width = 0;width < 8;width++){
                System.out.print(board[height][width]);
            }
            System.out.print("\n");
        }
    }
}

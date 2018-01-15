package jp.ac.uryukyu.ie.e175726;
import java.util.Scanner;
public class Board {
    private String[] board = new String[91];
    public static final String BLACK = "●";//黒のコマ
    public static final String WHITE = "◯";//白のコマ
    public static final String SPACE = " ";//空白のマス
    public static final String WALL = "x";//盤の外
    Scanner scan = new Scanner(System.in);
    byte[] asciiCodes;

    public Board(){
        for(int num=0;num<91;num++){board[num]=WALL;}
        for(int height = 1;height < 9;height++){
            for(int width = 1;width < 9;width++){
                board [height*9+width]=SPACE;
            }
        }
        //初期配置のコマ
        board[40]=BLACK;
        board[41]=WHITE;
        board[50]=BLACK;
        board[49]=WHITE;
    }
//ボード表示
    public void Showboard(){
        System.out.println(" ABCDEFGH");
        for(int height = 1;height < 9;height++){
            System.out.print(height);
            for(int width = 1;width < 9;width++){
                System.out.print(board[height*9+width]);
            }
            System.out.print("\n");
        }
    }
//黒のコマを置く
    public void PutBrackStorn(){
        int height,pos;
        String point;
        System.out.println("黒プレイヤーのターン");
        System.out.println("置きたい場所を入力してください。");
        System.out.print("数字: ");
        height = scan.nextInt();
        System.out.print("英語: ");
        point = scan.next();

        try{
            asciiCodes = point.getBytes("US-ASCII");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        pos=9*(height)+(asciiCodes[0]-64);
        ChangeBlack(pos,1);
        ChangeBlack(pos,-1);
        ChangeBlack(pos,-9);
        ChangeBlack(pos,-10);
        ChangeBlack(pos,-11);
        ChangeBlack(pos,9);
        ChangeBlack(pos,10);
        ChangeBlack(pos,11);
        board[pos]=BLACK;

    }

    //白の石を黒に変える
    int ChangeBlack(int m, int dir)
    {
        int i=0, n=m+dir;

        while(board[n]==WHITE)
            n+=dir;

        if(board[n]!=BLACK)
            return 0;

        n-=dir;
        while(n!=m){
            board[n]=BLACK;
            n-=dir;
            i++;
        }

        return i;
    }
}

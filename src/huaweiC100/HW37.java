package huaweiC100;

import java.util.Scanner;

public class HW37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            int[][] g=new int[19][19];
            String source1 = in.nextLine();
            String[] split1 = source1.split(" ");
            for (int i = 0; i <split1.length/2 ; i++) {
               g[Integer.valueOf(split1[2*i])][Integer.valueOf(split1[2*i+1])]=1;
            }
            String source2 = in.nextLine();
            String[] split2 = source2.split(" ");
            for (int i = 0; i <split2.length/2 ; i++) {
                g[Integer.valueOf(split2[2*i])][Integer.valueOf(split2[2*i+1])]=2;
            }
            int[][] blackScore=new int[19][19];
            int[][] whiteScore=new int[19][19];
            int blackTotal=0;
            int whiteTotal=0;
            for (int i = 0; i < 19; i++) {
                for (int j = 0; j < 19; j++) {
                    if (g[i][j]==1&&i-1>=0&&g[i-1][j]==0){
                        blackScore[i-1][j]=3;
                    }
                    if (g[i][j]==1&&i+1<19&&g[i+1][j]==0){
                        blackScore[i+1][j]=3;
                    }
                    if (g[i][j]==1&&j-1>=0&&g[i][j-1]==0){
                        blackScore[i][j-1]=3;
                    }
                    if (g[i][j]==1&&j+1<19&&g[i][j+1]==0){
                        blackScore[i][j+1]=3;
                    }
                    if (g[i][j]==2&&i-1>=0&&g[i-1][j]==0){
                        whiteScore[i-1][j]=4;
                    }
                    if (g[i][j]==2&&i+1<19&&g[i+1][j]==0){
                        whiteScore[i+1][j]=4;
                    }
                    if (g[i][j]==2&&j-1>=0&&g[i][j-1]==0){
                        whiteScore[i][j-1]=4;
                    }
                    if (g[i][j]==2&&j+1<19&&g[i][j+1]==0){
                        whiteScore[i][j+1]=4;
                    }
                }
            }
            for (int i = 0; i < 19; i++) {
                for (int j = 0; j <19 ; j++) {
                    if(blackScore[i][j]==3){
                        blackTotal++;
                    }
                    if(whiteScore[i][j]==4){
                        whiteTotal++;
                    }
                }
            }
            System.out.println(blackTotal+" "+whiteTotal);


        }


    }
}

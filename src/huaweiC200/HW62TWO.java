package huaweiC200;

import java.util.Scanner;

public class HW62TWO {
    static int[][] g;
    static boolean[][]  used;
    static int max=Integer.MIN_VALUE;

    static int[][] route={{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        g=new int[row][column];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <column ; j++) {
                g[i][j]=in.nextInt();
            }
        }

        used=new boolean[row][column];

        for (int i = 0; i <row; i++) {
            for (int j = 0; j <column ; j++) {
                used[i][j]=true;
                dfs(i,j,-1,0);
                used[i][j]=false;
            }
        }
        System.out.println(max);

    }
    public  static void dfs(int i,int j,int dir,int count){
        max=Math.max(max,count);

        for (int k = 0; k <4 ; k++) {
            int curX=i+route[k][0];
            int curY=j+route[k][1];
            if(curX<0||curY<0||curX>=g.length||curY>=g[0].length||used[curX][curY]) continue;
            int curDir=g[curX][curY]>g[i][j]?1:0;
            if(curDir!=dir){
                used[curX][curY]=true;
               dfs(curX,curY,curDir,count+1);
                used[curX][curY]=false;
            }
        }
    }
}

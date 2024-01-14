package huaweiC200;

import java.util.Scanner;

public class HW62 {
    static int[][] route={{1,0},{-1,0},{0,1},{0,-1}};
    static int max;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] g=new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j]=in.nextInt();

                }
            }
            boolean[][] used=new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    used[i][j]=true;
                    dfs(g,i,j,-1,0,used);
                    used[i][j]=false;
                }
            }
            System.out.println(max);

        }
    }
    public static void dfs(int[][] g,int x,int y,int dir,int count, boolean[][] used){
        max=Math.max(max,count);

        for (int i = 0; i < 4; i++) {
             int currentX=x+route[i][0];
             int currentY=y+route[i][1];

            if(currentX<0||currentY<0||currentX>= g.length||currentY>=g[0].length||g[x][y]==g[currentX][currentY]||used[currentX][currentY]){
                continue;
            }
            int curDir=g[currentX][currentY]>g[x][y]?1:0;
            if(curDir!=dir){
                used[currentX][currentY]=true;
                dfs(g,currentX,currentY,curDir,count+1,used);
                used[currentX][currentY]=false;
            }

        }





    }
}

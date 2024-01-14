package huaweiC200;

import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] g=new int[m][n];
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j <n ; j++) {
                    g[i][j]=in.nextInt();
                }
            }
            int MaxArea=Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j <n ; j++) {
                    if(g[i][j]==1){
                        MaxArea=Math.max(dfs(g,i,j),MaxArea);

                    }
                }
            }
            System.out.println(MaxArea);
        }
    }
    public static  int dfs( int[][] g,int x,int y){
         if(x<0||y<0||x>=g.length||y>=g[0].length||g[x][y]==0){
             return 0;
         }
         g[x][y]=0;
         return dfs(g,x+1,y)+
                 dfs(g,x-1,y)+
                 dfs(g,x,y+1)+
                 dfs(g,x,y-1)+1;
    }
}


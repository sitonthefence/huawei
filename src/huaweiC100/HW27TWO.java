package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW27TWO {
    static int count;
    static int[][] memory;
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
            memory=new int[m][n];
            for (int i = 0; i < memory.length; i++) {
                Arrays.fill(memory[i],-1);
            }


            dfs(g,0,0);

            System.out.println(count);
        }
    }
    public static void  dfs(int[][] g,int x,int y){
          if(x<0||y<0||x>=g.length||y>=g[0].length||g[x][y]==1){
              return ;
          }
          if(x== g.length-1&&y==g[0].length-1){
              count++;

          }
           dfs(g,x+1,y);
           dfs(g,x,y+1);

    }


}

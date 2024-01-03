package huaweiC100;

import java.util.Scanner;

public class HW70 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();
            int[][]g=new int[m][n];
            boolean [][] used=new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(getSum(i)+getSum(j)<=k){
                        g[i][j]=1;
                    }
                }
            }
            dfs(g,used,0,0);
            int count=0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j <n ; j++) {
                  if(used[i][j]){
                      count++;
                  }
                }
            }
            System.out.println(count);
        }
    }
    public static int getSum(int num){
        return num/10+num%10;
    }
    public static void dfs(int[][]g, boolean [][] used,int x,int y){
        if(x<0||y<0||x>=g.length||y>=g[0].length||g[x][y]==0||used[x][y]){
            return ;
        }
        used[x][y]=true;
        dfs(g,used,x+1,y);
        dfs(g,used,x-1,y);
        dfs(g,used,x,y+1);
        dfs(g,used,x,y-1);


    }


}

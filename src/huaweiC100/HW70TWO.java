package huaweiC100;

import java.util.Scanner;

public class HW70TWO {
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
            int count=0;
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j <n ; j++) {
                    if(g[i][j]==1){
                     used=new boolean[m][n];
                        if(dfs(0,0,i,j,used,g)) count++;
                        
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static int getSum(int num){
        return num/10+num%10;
    }
    public static boolean dfs(int currentX,int currentY,int endX,int endY, boolean [][] used, int[][]g){


        if(currentX<0||currentY<0||currentX>=g.length||currentY>=g[0].length||g[currentX][currentY]==0||used[currentX][currentY]){
            return false;
        }
        if(currentX==endX&&currentY==endY){
            return true;
        }
        used[currentX][currentY]=true;
        return dfs(currentX+1,currentY,endX,endY,used,g)||
                dfs(currentX-1,currentY,endX,endY,used,g)||
                dfs(currentX,currentY+1,endX,endY,used,g)||
                dfs(currentX,currentY-1,endX,endY,used,g);
    }
}

package huaweiC200;

import java.util.Scanner;

public class HW67TWO {
    static int[][] g;
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
        int target=0;
        int left=0;
        int right=65535;
        while (left<right) {
            boolean[][] used=new boolean[row][column];
            int mid=(left+right)/2;
            if(dfs(mid,0,0,used)){
                target=mid;
                left=mid+1;
            }else {
                right=mid;
            }
        }
        System.out.println(target);
    }
    public  static  boolean dfs(int mid,int i,int j, boolean[][] used){
          if(i<0||j<0||i>= used.length||j>=used[0].length||g[i][j]<mid||used[i][j]){
              return false;
          }
          if(i== g.length-1&&j==g[0].length-1&&g[i][j]>=mid){
              return true;
          }
          used[i][j]=true;
        return dfs(mid,i+1,j,used)||
                dfs(mid,i-1,j,used)||
                dfs(mid,i,j+1,used)||
                dfs(mid,i,j-1,used);


    }
}

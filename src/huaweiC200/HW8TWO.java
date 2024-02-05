package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW8TWO {
      static  int row;
      static int column;
      static int[][] matrix;
      static int K;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         row = in.nextInt();
         column = in.nextInt();
        K=in.nextInt();
        matrix=new int[row][column];
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j]=in.nextInt();
                max=Math.max(max,matrix[i][j]);
            }
        }
        int left=0;
        int right=max;
        int target=max;
        while (left<right){
            int mid=(left+right)/2;
            if(check(mid)){
                right=mid;
                target=mid;

            }else {
                left=mid+1;
            }
        }
        System.out.println(target);
    }
    public  static  boolean check(int mid){
         int[] matcher=new int[column];
        Arrays.fill(matcher,-1);
        int count=0;
        for (int i = 0; i < row; i++) {
            boolean[] used=new boolean[column];
            if(dfs(mid,used,i,matcher)){
                count++;
            }


        }
         return count>=row-K+1;

    }
    public static boolean dfs(int mid,boolean[] used,int i, int[] matcher){
        for (int j = 0; j < column; j++) {
            if(!used[j]&&matrix[i][j]<=mid){
                used[j]=true;
                if(matcher[j]==-1||dfs(mid,used,matcher[j],matcher)){
                    matcher[j]=i;
                    return true;
                }
            }


        }
        return  false;
    }

}

package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW8THREE {
    static int row;
    static int column;
    static int[][] matrix;
    static int K;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        row = in.nextInt();
        column = in.nextInt();
        K = in.nextInt();
        matrix = new int[row][column];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = in.nextInt();
                max = Math.max(max, matrix[i][j]);
            }
        }
        int left = 0;
        int right = max;
        int target = max;
        while (left < right) {
            int mid = (left + right) / 2;
            if(check(mid)){
                right=mid;
                target=mid;
            }else {
                left=mid+1;
            }
        }
        System.out.println(target);

    }
    public static boolean check(int mid){
        int[] mather=new int [column];
        Arrays.fill(mather,-1);
        int count=0;
        for (int i = 0; i <row ; i++) {
            boolean[] visited=new boolean[column];
            if(dfs(mather,i,visited,mid)){
                count++;
            }
        }
        return count>=row-K+1;





    }
    public static  boolean dfs(int[] mather,int i,boolean[] visited,int mid){
        for (int j = 0; j < column; j++) {
            if(!visited[j]&&matrix[i][j]<=mid){
                visited[j]=true;
                if(mather[j]==-1||dfs(mather,mather[j],visited,mid)){
                    mather[j]=i;
                    return true;
                }
            }
        }
        return false;

    }


}
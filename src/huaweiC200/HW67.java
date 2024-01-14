package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW67 {

    static int row;
    static int column;
    static int[][] g;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        row = in.nextInt();
        column = in.nextInt();
        g=new int[row][column];
        visited=new boolean[row][column];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <column ; j++) {
                g[i][j]=in.nextInt();
            }
        }
        int target=1;
        int left=target;
        int right=65536;
        while (left<right){
            int mid=(left+right)/2;
            for (int i = 0; i < visited.length; i++) {
                Arrays.fill(visited[i],false);
            }
            if(dfs(0,0,mid)){
                target=mid;
                left=mid+1;

            }else {
                right=mid;
            }
        }
        System.out.println(target);
    }
    static boolean dfs(int i,int j,int x){
        if(i<0||j<0||i>=g.length||j>=g[0].length||g[i][j]<x||visited[i][j]){
            return false;
        }
        if(i==g.length-1&&j==g[0].length-1){
            return true;
        }
        visited[i][j]=true;
        return    dfs(i+1, j, x)||dfs(i-1, j, x)||dfs(i, j+1, x)||    dfs(i, j-1, x);

    }

}

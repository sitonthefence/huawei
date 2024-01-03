package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW53 {
    public static int N;

   public static int[] arr;
    public static int [][] g;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
              N = in.nextInt();
              arr=new int[N];
            for (int i = 0; i < N; i++) {
                arr[i]=in.nextInt();
            }
            int max=Integer.MIN_VALUE;
              g=new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(g[i],-1);
            }
            for (int i = 0; i <arr.length ; i++) {
                max=Math.max(max,dfs((i+1)%N,(i-1+N)%N)+arr[i]);
            }
            System.out.println(max);
        }

    }
    public static int dfs(int left,int right){
        if(g[left][right]!=-1){
            return g[left][right];
        }
        if(left==right){
            g[left][right]=arr[left];
            return g[left][right];
        }
        if (arr[left]>arr[right]) {
            left=(left+1)%N;
        }else {
            right=(right-1+N)%N;
        }
        if(g[left][right]!=-1){
            return g[left][right];
        }
        if(left==right){
            g[left][right]=arr[left];
            return g[left][right];
        }
        return Math.max(arr[left]+dfs((left+1)%N,right),arr[right]+dfs(left,(right-1+N)%N));








    }
}

package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW53TWO {
      static int[] arr;
    static long[][] mem;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        arr=new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=in.nextInt();
        }
        long maxPizzaTotal=Long.MIN_VALUE;
        mem=new long[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(mem[i],-1);
        }
        for (int i = 0; i < arr.length; i++) {
            maxPizzaTotal=Math.max(maxPizzaTotal,getMax((i+1)%arr.length,(i-1+arr.length)%arr.length)+arr[i]);
        }
        System.out.println(maxPizzaTotal);

    }
    public static long getMax(int left,int right){
  /*      if(mem[left][right]!=-1){
            return mem[left][right];
        }
        if(left==right){
            mem[left][right]=arr[left];
            return arr[left];
        }*/

    if(arr[left]>arr[right]){
        left=(left+1)%arr.length;
    }else {
        right=(right-1+arr.length)%arr.length;
    }
        if(mem[left][right]!=-1){
            return mem[left][right];
        }
        if(left==right){
            mem[left][right]=arr[left];
            return arr[left];
        }
        mem[left][right]=Math.max(arr[left]+getMax((left+1)%arr.length,right),arr[right]+getMax(left,(right-1+arr.length)%arr.length));
       return mem[left][right];

    }




}

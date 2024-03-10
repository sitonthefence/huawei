package jikao;

import java.util.Arrays;
import java.util.Scanner;

public class HW12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] g=new int[19][19];
        int[][] black=new int[19][19];
        int[][] white=new int[19][19];
        int[] arr1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < arr1.length/2; i++) {
            g[arr1[2*i]][arr1[2*i+1]]=1;
        }
        int[] arr2 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < arr2.length/2; i++) {
            g[arr2[2*i]][arr2[2*i+1]]=2;
        }
        for (int i = 0; i <g.length ; i++) {
            for (int j = 0; j <g[0].length ; j++) {
                if(g[i][j]==1){
                    if(i-1>=0&&g[i-1][j]==0){
                        black[i-1][j]=1;
                    }
                    if(i+1<g.length&&g[i+1][j]==0){
                        black[i+1][j]=1;
                    }
                    if(j-1>=0&&g[i][j-1]==0){
                        black[i][j-1]=1;
                    }
                    if(j+1<g[0].length&&g[i][j+1]==0){
                        black[i][j+1]=1;
                    }

                }else if(g[i][j]==2){
                    if(i-1>=0&&g[i-1][j]==0){
                        white[i-1][j]=1;
                    }
                    if(i+1<g.length&&g[i+1][j]==0){
                        white[i+1][j]=1;
                    }
                    if(j-1>=0&&g[i][j-1]==0){
                        white[i][j-1]=1;
                    }
                    if(j+1<g[0].length&&g[i][j+1]==0){
                        white[i][j+1]=1;
                    }
                }

            }
        }
        int countBlack=0;
        int countWhite=0;
        for (int i = 0; i <g.length ; i++) {
            for (int j = 0; j <g[0].length ; j++) {
                if(black[i][j]==1){
                    countBlack++;
                }
                if(white[i][j]==1){
                    countWhite++;
                }

            }
        }
        System.out.println(countBlack+" "+countWhite);

    }
}

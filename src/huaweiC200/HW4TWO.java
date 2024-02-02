package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW4TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int INF=Integer.MAX_VALUE/2;
        int computerNum = in.nextInt();
        int[][] g=new int[computerNum][computerNum];
        for (int i = 0; i <g.length ; i++) {
            Arrays.fill(g[i],INF);
        }

        int networkNum = in.nextInt();
         for (int i = 0; i <networkNum ; i++) {
            g[in.nextInt()-1][in.nextInt()-1]=in.nextInt();
        }
        int start=in.nextInt()-1;
        int[] distance=new int[computerNum];
        Arrays.fill(distance,INF);
        distance[start]=0;
        boolean used[]=new boolean[computerNum];
        for (int i = 0; i < computerNum; i++) {
            int index=-1;
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < computerNum; j++) {
                if(!used[j]&&distance[j]<min){
                    min=distance[j];
                    index=j;
                }
            }
            used[index]=true;
            for (int j = 0; j <computerNum ; j++) {
                distance[j]=Math.min(distance[j],distance[index]+g[index][j]);
            }
        }
      int max=Integer.MIN_VALUE;
        for (int i = 0; i < distance.length; i++) {
            max=Math.max(max,distance[i]);
        }
        if(max==INF){
            System.out.println(-1);
        }else {
            System.out.println(max);
        }
    }
}

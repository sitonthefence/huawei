package huaweiAB200;

import java.util.Arrays;
import java.util.Scanner;

public class HW6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int INF=Integer.MAX_VALUE/2;
            int n=in.nextInt();
            int m=in.nextInt();
            int[][] g=new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(g[i],INF);
            }
            for (int i = 0; i < m; i++) {
                g[in.nextInt()-1][in.nextInt()-1]=in.nextInt();
            }
            int source=in.nextInt();
            int target=in.nextInt();
            int[] toDistance=new int[n];
            Arrays.fill(toDistance,INF);
            toDistance[source-1]=0;
            boolean[] used=new boolean[n];
            for (int i = 0; i < n; i++) {
                int index=-1;
                int min=Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                   if(!used[j]&&toDistance[j]<min){
                       min=toDistance[j];
                       index=j;
                   }
                }
                used[index]=true;
                for (int j = 0; j < n; j++) {
                    toDistance[j]=Math.min(toDistance[j],toDistance[index]+g[index][j]);
                }
            }
            System.out.println(toDistance[target-1]);
        }
    }
}

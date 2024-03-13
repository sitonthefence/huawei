package LC;

import java.util.Arrays;

public class LC743网络延迟时间 {

    public int networkDelayTime(int[][] times, int n, int k) {
        int INF=Integer.MAX_VALUE/2;
        int[][]g=new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i],INF);
        }
        for (int i = 0; i < times.length; i++) {
              g[times[i][0]-1][times[i][1]-1]=times[i][2];
        }
        boolean[] used=new boolean[n];
        int[] toDistance =new int[n];

        Arrays.fill(toDistance,INF);
        toDistance[k-1]=0;
        for (int i = 0; i < n; i++) {
            int x=-1;
            for (int y = 0; y < n; y++) {
                if(!used[y]&&(x==-1||toDistance[y]<toDistance[x])){
                    x=y;
                }
            }
            used[x]=true;
            for (int y = 0; y < n; y++) {
              toDistance[y]=Math.min(toDistance[y],toDistance[x]+g[x][y]);
            }
        }
        int maxDistance=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(toDistance[i]>maxDistance){
                maxDistance=toDistance[i];
            }
        }
     if(maxDistance==INF) {
         return -1;
     }
     return maxDistance;


    }
}

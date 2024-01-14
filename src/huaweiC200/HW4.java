package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int INF=Integer.MAX_VALUE/2;
            int computerNum = in.nextInt();
             int[][] g=new int[computerNum][computerNum];
            for (int i = 0; i < g.length; i++) {
                Arrays.fill(g[i],INF);
            }
            int routeNum = in.nextInt();
            for (int i = 0; i <routeNum ; i++) {
                g[in.nextInt()-1][in.nextInt()-1]=in.nextInt();
            }
            int start=in.nextInt()-1;
            int toDistance[]=new int[computerNum];
            Arrays.fill(toDistance,INF);
            toDistance[start]=0;

            boolean[] used=new boolean[computerNum];
            //第一次的更新也在for循环
          /*  used[start]=true;*/
            for (int i = 0; i < computerNum; i++) {
              int index=-1;
              int min=Integer.MAX_VALUE;
                for (int j = 0; j < computerNum; j++) {
                  if(!used[j]&&toDistance[j]<min){
                      min=toDistance[j];
                      index=j;
                  }
                }
                used[index]=true;
                for (int j = 0; j < computerNum; j++) {
                   toDistance[j]=Math.min(toDistance[j],toDistance[index]+g[index][j]);
                }
            }
            int result=Integer.MIN_VALUE;
            for (int i = 0; i < toDistance.length; i++) {
                result=Math.max(result,toDistance[i]);

            }
            if(result==INF){
                System.out.println(-1);
            }else {
                System.out.println(result);
            }







        }


    }
}

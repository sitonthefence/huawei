package huaweiC200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW58 {
    public static int minDistance=Integer.MAX_VALUE;
    public  static int[][] g;
    public static boolean[]used;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int customer = in.nextInt();
        int hasKnown = in.nextInt();
         g=new int[customer+1][customer+1];
        int INF=Integer.MAX_VALUE/2;
        for (int i = 0; i < g.length; i++) {
            Arrays.fill(g[i],INF);
        }
        for (int i = 0; i < customer+1; i++) {
            g[i][i]=0;
        }
         Map<Integer,Integer> map=new HashMap<>();
        for (int i = 1; i <= customer; i++) {
            int id = in.nextInt();
            map.put(id,i);
            int distance = in.nextInt();
            g[0][i]=distance;
            g[i][0]=distance;
        }
        for (int i = 0; i <hasKnown ; i++) {
            int id1 = in.nextInt();
            int id2 = in.nextInt();
            int distance = in.nextInt();
            g[map.get(id1)][map.get(id2)]=distance;
            //不能少
            g[map.get(id2)][map.get(id1)]=distance;
        }
        int n=customer+1;
        for (int k = 0; k<n ; k++) {
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <n ; j++) {
                    g[i][j]=Math.min(g[i][j],g[i][k]+g[k][j]);

                }
            }
        }
        used=new boolean[customer+1];
        dfs(0,0,customer,0);
        System.out.println(minDistance);


    }
    public static void dfs(int prePoint,int level,int customer,int currentSum){
        if(level==customer){
            minDistance=Math.min(minDistance,currentSum+g[prePoint][0]);
        }
        for (int i =1; i <= customer; i++) {
            if(!used[i]){
                used[i]=true;
                dfs(i,level+1,customer,currentSum+g[prePoint][i]);

                used[i]=false;
            }
        }
    }
}

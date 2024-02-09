package huaweiC200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW58TWO {
    static int min=Integer.MAX_VALUE;
    static int [][] distance;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int customer = in.nextInt();
        int hasKnown=in.nextInt();
      distance=new int[customer+1][customer+1];
        int INF=Integer.MAX_VALUE/2;
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i],INF);
        }
        for (int i = 0; i < customer+1; i++) {
            distance[i][i]=0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 1; i <=customer ; i++) {
            int id = in.nextInt();
            int dis=in.nextInt();
            map.put(id,i);
            distance[0][i]=dis;
            distance[i][0]=dis;
        }
        for (int i = 0; i < hasKnown; i++) {
            int a = map.get(in.nextInt());
            int b = map.get(in.nextInt());
            int dis = in.nextInt();
            distance[a][b]=dis;
            distance[b][a]=dis;
        }
        int n=customer+1;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <n ; j++) {
                    distance[i][j]=Math.min(distance[i][j],distance[i][k]+distance[k][j]);
                }
            }
        }
        boolean[] used=new boolean[customer+1];
        dfs(0,used,0,0,customer);
        System.out.println(min);

    }
    public static void dfs(int pre, boolean[] used,int level,int currentSum,int customerNum){
     if(level==customerNum){
         min=Math.min(min,currentSum+distance[pre][0]);
     }
        for (int i = 1; i <=customerNum ; i++) {
            if(used[i]) continue;
            used[i]=true;
            dfs(i,used,level+1,currentSum+distance[pre][i],customerNum);
            used[i]=false;

        }

    }


}

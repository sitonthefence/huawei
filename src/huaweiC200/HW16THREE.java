package huaweiC200;

import java.util.*;

public class HW16THREE {
       static int[][] route={{0,1},{1,0},{0,-1},{-1,0}};

        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            String source = in.next();
            String[] split = source.split(",");
            int m=Integer.parseInt(split[0]);
            int n=Integer.parseInt(split[1]);
            int[][] g=new int[m][n];
            for (int i = 0; i < m; i++) {
                g[i]= Arrays.stream(in.next().split(",")).mapToInt(Integer::parseInt).toArray();
            }
            boolean dfs = bfs(g, 100, new boolean[m][n]);
            if(!dfs){
                System.out.println(-1);
               return;
            }
            int left=0;
            int right=100;
            int ans=right;
            while (left<right){
                int middle=(left+right)/2;
                if( bfs(g,  middle, new boolean[m][n])){
                    ans=middle;
                    right=middle;
                }else {
                    left=middle+1;

                }
            }
            System.out.println(ans);


    }
        public static boolean bfs( int[][] g,int total, boolean[][] used){
            int [][] distance=new int[g.length][g[0].length];
            for (int i = 0; i < g.length; i++) {
                Arrays.fill(distance[i], -1);
            }
            if(g[0][0]==-1){
                distance[0][0]=100;
            }else {
                distance[0][0]=total-g[0][0];
            }
            if (distance[0][0]<0||g[0][0]==0){
                return false;
            }

            PriorityQueue<int[]> deque=new PriorityQueue<>((a,b)->b[2]-a[2]);
            deque.add(new int[]{0,0,distance[0][0]});
            used[0][0]=true;

            while (!deque.isEmpty()){
                int[] fa = deque.poll();
                int x=fa[0];
                int y = fa[1];
                int w = fa[2];
        /*        if(used[x][y]){
                    continue;
                }
*/

                for (int i = 0; i <4 ; i++) {
                    int xx=x+route[i][0];
                    int yy=y+route[i][1];
                    if(xx<0||yy<0||xx>=g.length||yy>=g[0].length||g[xx][yy]==0||used[xx][yy]) continue;
                    if(g[xx][yy]==-1){
                        distance[xx][yy]=100;
                    }else {
                        distance[xx][yy]=w-g[xx][yy];
                    }
                    if(distance[xx][yy]>=0){
                        deque.add(new int[]{xx,yy,distance[xx][yy]});
                        used[xx][yy]=true;

                    }
                }
            }
        return used[g.length-1][g[0].length-1];
    }
}

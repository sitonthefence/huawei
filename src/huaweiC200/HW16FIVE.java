package huaweiC200;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW16FIVE {
     static int[][] g;
     static int[][] route={{1,0},{-1,0},{0,-1},{0,1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String source = in.next();
        String[] split = source.split(",");
        int m=Integer.parseInt(split[0]);
        int n=Integer.parseInt(split[1]);
        g=new int[m][n];
        for (int i = 0; i < m; i++) {
            g[i]= Arrays.stream(in.next().split(",")).mapToInt(Integer::parseInt).toArray();
        }

        if(!bfs(100)){
            System.out.println(-1);
            return;
        }

        int left=0;
        int right=100;
        int target=right;
        while (left<right){
            int mid=(left+right)/2;
            if(bfs(mid)){
                right=mid;
                target=mid;

            }else {
                left=mid+1;
            }

        }
        System.out.println(target);



    }
    public static boolean bfs(int startGasoline){

        boolean[][] used=new boolean[g.length][g[0].length];
        int[][] distance=new int[g.length][g[0].length];
        PriorityQueue<int[]> deque=new PriorityQueue<>((a,b)->b[2]-a[2]);
        if (g[0][0] == -1) {
            distance[0][0]=100;
        }else if(g[0][0]>0){
            distance[0][0]=startGasoline-g[0][0];
        }
        if(distance[0][0]<0||g[0][0]==0){
            return false;
        }
        deque.add(new int[]{0,0,distance[0][0]});
        while (!deque.isEmpty()){
            int[] fa = deque.poll();
            int x=fa[0];
            int y=fa[1];
            int dis=fa[2];
            used[x][y]=true;
            for (int i = 0; i < 4; i++) {
                int curX=x+route[i][0];
                int curY=y+route[i][1];
               if(curX<0||curY<0||curX>=g.length||curY>=g[0].length||g[curX][curY]==0||used[curX][curY]) continue;
                if(g[curX][curY]==-1){
                    distance[curX][curY]=100;
                }else {
                    distance[curX][curY]=dis-g[curX][curY];
                }
                if(distance[curX][curY]>=0){
                    deque.add(new int[]{curX,curY,distance[curX][curY]});
                }
            }
        }

        return used[g.length-1][g[0].length-1];






    }
}

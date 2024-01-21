package huaweiC200;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class HW18 {
    static char[][] g;
    static int[][] totalStep;
    static HashSet<Integer> reached;
    static int[][] route;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        g=new char[m][n];
        for (int i = 0; i <m ; i++) {
            g[i]=in.next().toCharArray();
        }
        totalStep=new int[m][n];
        reached=new HashSet<>();
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                reached.add(i*n+j);
            }
        }
        route=new int[][]{{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,-1},{-2,1}};
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
              if(g[i][j]!='.'){
                  bfs(i,j,g[i][j]-'0');
              }
            }
        }
        int min=Integer.MAX_VALUE;
        if(reached.size()==0){
            System.out.println(-1);
        }else {
            for (Integer integer : reached) {
                //注意
                  int x=integer/g[0].length;
                  int y=integer%g[0].length;

                  min=Math.min(min,totalStep[x][y]);

            }
            System.out.println(min);

        }
    }
    //bsf的k和deque是不一样的


    public static void bfs(int i,int j,int k){
        HashSet<Integer> singleReach=new HashSet<>();
        boolean[][] visited=new boolean[g.length][g[0].length];
        ArrayDeque<int []> deque=new ArrayDeque<>();
        deque.add(new int[]{i,j,0});
        visited[i][j]=true;
        singleReach.add(i* g[0].length+j);
        while (!deque.isEmpty()&&k>0){
            int size = deque.size();
            for (int l = 0; l < size; l++) {
                int[] temp = deque.pollFirst();
                for (int m = 0; m < 8; m++) {
                    int nextX=temp[0]+route[m][0];
                    int nextY=temp[1]+route[m][1];
                    int step=temp[2];
                    if(nextX<0||nextY<0||nextX>=g.length||nextY>=g[0].length||visited[nextX][nextY]) continue;
                    deque.offerLast(new int[]{nextX,nextY,step+1});
                    totalStep[nextX][nextY]+=step+1;
                   singleReach.add(nextX* g[0].length+nextY);
                   visited[nextX][nextY]=true;
                }
            }
            k--;
            }
        reached.retainAll(singleReach);
        }
}

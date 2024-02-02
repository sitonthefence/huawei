package huaweiC200;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class HW18TWO {
   static char[][] g;
   static HashSet<Integer> reached;
   static int[][] stepTotal;
   static int[][] route;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        g=new char[row][column];
        for (int i = 0; i < row; i++) {
            g[i]=in.next().toCharArray();
        }
        stepTotal=new int[row][column];
        route=new int[][]{{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};
        reached=new HashSet<>();
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <column ; j++) {
                reached.add(i*g[0].length+j);
            }
        }
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <column ; j++) {
                if(g[i][j]!='.'){
                    bfs(i,j,g[i][j]-'0');
                }
            }
        }


      if(reached.size()==0){
          System.out.println(-1);
          return;
      }
      int min=Integer.MAX_VALUE;
        for (Integer point : reached) {
            min=Math.min(min,stepTotal[point/g[0].length][point%g[0].length]);
        }
        System.out.println(min);


    }
    public  static  void bfs(int i,int j,int k){
        boolean[][] used=new boolean[g.length][g[0].length];
        HashSet<Integer> currentReached=new HashSet<>();
        ArrayDeque<int[]> deque=new ArrayDeque<>();
        deque.add(new int[]{i,j,0});
        currentReached.add(i*g[0].length+j);
        used[i][j]=true;
        while (!deque.isEmpty()&&k>0){
             int size=deque.size();
            for (int l = 0; l <size ; l++) {
                int[] fa = deque.pollFirst();
                int x= fa[0];
                int y = fa[1];
                int step = fa[2];
                for (int m = 0; m <8 ; m++) {
                    int curX=x+route[m][0];
                    int curY=y+route[m][1];
                    if(curX<0||curY<0||curX>= g.length||curY>=g[0].length||used[curX][curY]) continue;
                    deque.add(new int[]{curX,curY,step+1});
                    //注意
                    stepTotal[curX][curY]+=step+1;
                    currentReached.add(curX*g[0].length+curY);
                    used[curX][curY]=true;
                }
            }

            k--;
        }
        reached.retainAll(currentReached);

    }



}

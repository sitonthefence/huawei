package huaweiC200;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HW41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int N = in.nextInt();
            int[][] g=new int[N][N];
            int[][] candy=new int[N][N];
            ArrayDeque<int[]> deque=new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    candy[i][j]=-1;
                    g[i][j]=in.nextInt();
                    if(g[i][j]==-3){
                        candy[i][j]=0;
                        deque.offerLast(new int[]{i,j});
                    }
                }
            }
            int[][] route={{1,0},{-1,0},{0,1},{0,-1}};
            int ans=-1;
           while (!deque.isEmpty()){
               boolean flag=false;
               //大坑
               int  m=deque.size();
               for (int i = 0; i <m; i++) {
                   int[] position = deque.pollFirst();
                   for (int j = 0; j <4 ; j++) {
                       int x=position[0]+route[j][0];
                       int y=position[1]+route[j][1];
                       if(x<0||y<0||x>=g.length||y>=g[0].length||g[x][y]==-1){
                           continue;
                       }
                       if(candy[x][y]==-1){
                           deque.add(new int[]{x,y});
                       }
                       //不在上面if内
                       candy[x][y]=Math.max(candy[x][y],Math.max(0,g[x][y])+candy[position[0]][position[1]]);
                      if(g[x][y]==-2){
                          ans=candy[x][y];
                          //影响效率
                          flag=true;
                      }
                   }
               }
               if(flag){
                  break;
               }

           }
            System.out.println(ans);
        }
    }
}

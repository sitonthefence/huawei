package huaweiC200;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HW41TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int g[][]=new int[N][N];
        ArrayDeque<int[]> deque=new ArrayDeque<>();
        int[][] candy=new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(candy[i],-1);
        }
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N ; j++) {
                g[i][j]=in.nextInt();
                if(g[i][j]==-3){
                    deque.add(new int[]{i,j});
                    candy[i][j]=0;
                }
            }
        }
        int[][] route={{1,0},{-1,0},{0,1},{0,-1}};
        int max=0;
        boolean flag=false;
        while (!deque.isEmpty()){

            int size= deque.size();
            for (int i = 0; i <size ; i++) {
                int[] fa = deque.pollFirst();
                int x = fa[0];
                int y = fa[1];
                for (int j = 0; j < 4; j++) {
                    int curX=x+route[j][0];
                    int curY=y+route[j][1];
                    if(curX<0||curY<0||curX>=N||curY>=N||g[curX][curY]==-1) continue;
                    if(candy[curX][curY]==-1){
                        deque.offerLast(new int[]{curX,curY});
                    }
                    candy[curX][curY]=Math.max(candy[curX][curY],Math.max(0,g[curX][curY])+candy[x][y]);
                   if(g[curX][curY]==-2){
                       max=  candy[curX][curY];
                       flag=true;
                   }
                }
            }
            if(flag){
                break;
            }
        }
        if(!flag){
            System.out.println(-1);
        }else {
            System.out.println(max);
        }

    }
}

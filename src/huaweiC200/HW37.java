package huaweiC200;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HW37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int row = in.nextInt();
            int column = in.nextInt();
            int [][]g=new int[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    g[i][j]=in.nextInt();
                }
            }
            int[][] route={{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}};
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                  if(g[i][j]==5){
                      for (int k = 0; k <8 ; k++) {
                          int nextX=i+route[k][0];
                          int nextY=j+route[k][1];
                          if(nextX>=0&&nextY>=0&&nextX<row&&nextY<column&&g[nextX][nextY]!=5){
                              g[nextX][nextY]=2;
                          }
                      }
                  }
                }
            }
            int count=0;
            for (int i = 0; i <row ; i++) {
                for (int j = 0; j <column ; j++) {
                    if(g[i][j]==2){
                        bfs(i,j,g,route);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void bfs(int i,int j, int [][]g, int[][] route){
        ArrayDeque<int[]> deque=new ArrayDeque<>();
        deque.add(new int[]{i,j});
        g[i][j]=0;
        while (!deque.isEmpty()){
            int[] ints = deque.pollFirst();
            for (int k = 0; k < 8; k++) {
                int currentX=ints[0]+route[k][0];
                int currentY=ints[1]+route[k][1];
                if(currentX>=0&&currentY>=0&&currentX< g.length&&currentY<g[0].length&&g[currentX][currentY]==2){
                    deque.offerLast(new int[]{currentX,currentY});
                    g[currentX][currentY]=0;
                }
            }
        }
    }

}

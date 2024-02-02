package huaweiC200;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HW2TWO {
    public  static int[][] route={{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        int[][] g=new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                g[i][j]=in.nextInt();
            }
        }
        int max=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <column ; j++) {
                if(g[i][j]==1){
                    max=Math.max(max,bfs(g,i,j));
                }
            }
        }
        System.out.println(max);

    }
    public  static  int  bfs(int[][] g,int i,int j){

        ArrayDeque<int[]> deque=new ArrayDeque<>();
        deque.add(new int[]{i,j});
        g[i][j]=0;
        int area=1;
        while (!deque.isEmpty()){
            int[] ints = deque.pollFirst();
            for (int k = 0; k < 4; k++) {
                int currentX=route[k][0]+ints[0];
                int currentY=route[k][1]+ints[1];
                if(currentX<0||currentY<0||currentX>=g.length||currentY>=g[0].length||g[currentX][currentY]==0) continue;
                deque.offerLast(new int[]{currentX,currentY});
                g[currentX][currentY]=0;
                area++;
            }
        }
        return area;

    }





}

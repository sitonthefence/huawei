package huaweiC200;

import java.util.Scanner;

public class HW56 {
    static int min;
    static int[][] route;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] lights=new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    lights[i][j]=in.nextInt();
                }
            }
        int timePreRoad = in.nextInt();
        int rowStart = in.nextInt();
            int colStart = in.nextInt();
            int rowEnd = in.nextInt();
            int colEnd= in.nextInt();
            min=Integer.MAX_VALUE;
            route=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        calcTime(lights,timePreRoad,rowStart,colStart,rowEnd,colEnd);
            System.out.println(min);
        }
    static int calcTime(int[][] lights,int timePreRoad,int rowStart,int colStart, int rowEnd,int colEnd){
          boolean [][] visited=new boolean[lights.length][lights[0].length];
          //chatgpt
          visited[rowStart][colStart]=true;
          dfs(-1,-1,rowStart,colStart,lights,timePreRoad,rowEnd,colEnd,0,visited);
          visited[rowStart][colStart]=false;
          return min;
    }
    static void dfs(int preX,int preY,int CurX,int CurY,int[][] lights,int timePreRoad, int rowEnd,int colEnd,int time,boolean[][] visited){
        if(time>=min){
            return;
        }
      if (CurX==rowEnd&&CurY==colEnd){
         min =time;
         return;
      }

        for (int i = 0; i < 4; i++) {
            int nextX=CurX+route[i][0];
            int nextY=CurY+route[i][1];
            if(nextX>=0&&nextY>=0&&nextX<lights.length&&nextY<lights[0].length&&!visited[nextX][nextY]){
                visited[nextX][nextY]=true;
             //不要和下面的搞反
                 int cost=timePreRoad;
                if(preX>=0&&preY>=0&&check(preX,preY,CurX,CurY,nextX,nextY)>=0){
                    //注意坐标
                    cost+=lights[CurX][CurY];

                }

                dfs(CurX,CurY,nextX,nextY,lights,timePreRoad,rowEnd,colEnd,time+cost,visited);
                visited[nextX][nextY]=false;
            }
        }
    }
    static int check(int preX,int preY,int CurX,int CurY,int nextX,int nextY){
        int x1=CurX-preX;
        int y1=CurY-preY;
        int x2=nextX-CurX;
        int y2=nextY-CurY;
        return x1*y2-y1*x2;
    }

}

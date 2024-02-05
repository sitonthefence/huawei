package huaweiC200;
import java.util.PriorityQueue;
import java.util.Scanner;

// 本题实际考试为核心代码模式，即只需要写出下面Solution类实现即可
class Solution {


    int calcTime(int[][] lights, int timePerRoad, int rowStart, int colStart, int rowEnd, int colEnd) {
        int row=lights.length;
        int column=lights[0].length;
        int[][][] distance=new int[row][column][4];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (int k = 0; k < 4; k++) {
                    distance[i][j][k]=Integer.MAX_VALUE;
                }
            }
        }
        PriorityQueue<int[]> deque=new PriorityQueue<>((a,b)->a[4]-b[4]);

        for (int k = 0; k < 4;k++) {
            distance[rowStart][colStart][k]=0;
        }
        deque.add(new int[]{-1,-1,rowStart,colStart,0});
        int[][]  route={{1,0},{-1,0},{0,1},{0,-1}};
        while (!deque.isEmpty()){
            int[] poll = deque.poll();
            int preX=poll[0];
            int preY=poll[1];
            int curX=poll[2];
            int curY=poll[3];
            int total=poll[4];
            for (int k = 0; k < 4; k++) {
                int nextX=curX+route[k][0];
                int nextY=curY+route[k][1];
                if(nextX<0||nextY<0||nextX>=row||nextY>=column) continue;
                if(nextX==preX&&nextY==preY) continue;
                int currentCost=total+timePerRoad;
                if(preX!=-1&&preY!=-1&&calculateDirection(preX,preY,curX,curY,nextX,nextY)>=0){
                    currentCost+=lights[curX][curY];
                }
                if(currentCost>=distance[nextX][nextY][k]) continue;
                distance[nextX][nextY][k]=currentCost;
                deque.add(new int[]{curX,curY,nextX,nextY,currentCost});
            }
        }
        int min=Integer.MAX_VALUE;
        for (int k = 0; k <4 ; k++) {
            min=Math.min(min,distance[rowEnd][colEnd][k]);
        }
        return min;
    }
    int calculateDirection(int preX,int preY,int curX,int curY,int nextX,int nextY){
        int x1=curX-preX;
        int y1=curY-preY;
        int x2=nextX-curX;
        int y2=nextY-curY;
        return x1*y2-y1*x2;
    }
}

// 输入处理类，本题实际考试为核心代码模式，无需进行输入处理
public class HW56TWO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] lights = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lights[i][j] = sc.nextInt();
            }
        }

        int timePreRoad = sc.nextInt();

        int rowStart = sc.nextInt();
        int colStart = sc.nextInt();

        int rowEnd = sc.nextInt();
        int colEnd = sc.nextInt();

        System.out.println(
                new Solution().calcTime(lights, timePreRoad, rowStart, colStart, rowEnd, colEnd));
    }
}
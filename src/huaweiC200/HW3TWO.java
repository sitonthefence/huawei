package huaweiC200;


import java.util.ArrayDeque;
import java.util.Scanner;

public class HW3TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] g=new int[m][n];
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j <n ; j++) {
                    g[i][j]=in.nextInt();
                }
            }
            int[][] route={{1,0},{-1,0},{0,1},{0,-1}};
            int MaxArea=Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j <n ; j++) {
                    if(g[i][j]==1){
                        MaxArea=Math.max(bfs(g,i,j,route),MaxArea);

                    }
                }
            }
            System.out.println(MaxArea);
        }
    }
    public static int bfs(int[][]g,int x,int y,int[][] route){
        int area=0;
        ArrayDeque<int[]> deque=new ArrayDeque<>();
        deque.offerLast(new int[]{x,y});
        g[x][y]=0;
        area++;
        while (!deque.isEmpty()){
            int[] pollFirst = deque.pollFirst();
            for (int i = 0; i < 4; i++) {

                int a=pollFirst[0]+route[i][0];
                int b=pollFirst[1]+route[i][1];
                if(a<0||b<0||a>=g.length||b>=g[0].length||g[a][b]==0){
                    continue;
                }
                deque.offerLast(new int[]{a,b});
                g[a][b]=0;
                area++;
            }
        }
        return area;
    }

}


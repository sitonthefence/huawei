package huaweiC100;

import java.util.Scanner;

public class HW27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] g=new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j]=in.nextInt();
                }
            }
            int count = getCount(g, 0, 0);
            System.out.println(count);
        }
    }
    public static int getCount(int[][] g,int x,int y){
        if(x<0||y<0||x>=g.length||y>=g.length||g[x][y]==1){
            return 0;
        }
        if(x==g.length-1&&y==g.length-1){
            return 1;
        }
        return getCount(g,x+1,y)+getCount(g,x,y+1);

    }
}

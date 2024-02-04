package huaweiC200;

import java.util.Scanner;

public class HW16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            int m=Integer.valueOf(split[0]);
            int n=Integer.valueOf(split[1]);
            int[][] g=new int[m][n];
            for (int i = 0; i < m; i++) {
                String next = in.next();
                String[] split1 = next.split(",");
                for (int j = 0; j <n ; j++) {
                    g[i][j]=Integer.valueOf(split1[j]);
                }
            }
            boolean[][] used=new boolean[m][n];
            boolean dfs = dfs(g, 0, 0, 100, used);
           if(dfs==false){
               System.out.println(-1);
               continue;
           }
           int left=1;
           int right=100;
           int ans=right;
           while (left<right){
               int middle=(left+right)/2;
               if( dfs(g, 0, 0, middle, used)){
                   ans=middle;
                   right=middle;
               }else {
                  left=middle+1;

               }
           }
            System.out.println(ans);
        }

    }
    public static boolean dfs( int[][] g,int x,int y,int total, boolean[][] used){
        if(x<0||y<0||x>=g.length||y>=g[0].length||g[x][y]==0||total-g[x][y]<0||used[x][y]){
            return false;
        }
        if(x==g.length-1&&y==g[0].length-1){
            return true;
        }
        int temp=total;

        used[x][y]=true;
        boolean dfs1 = dfs(g, x+1, y, total, used);
        boolean dfs2 = dfs(g, x-1, y, total, used);
        boolean dfs3 = dfs(g, x, y+1, total, used);
        boolean dfs4 = dfs(g, x, y-1, total, used);
        used[x][y]=false;
        total=temp;
        return dfs1||dfs2||dfs3||dfs4;
    }

}

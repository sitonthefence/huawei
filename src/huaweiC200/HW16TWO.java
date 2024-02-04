package huaweiC200;
import java.util.Arrays;
import java.util.Scanner;

public class HW16TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            int m=Integer.parseInt(split[0]);
            int n=Integer.parseInt(split[1]);
            int[][] g=new int[m][n];
            for (int i = 0; i < m; i++) {
                g[i]= Arrays.stream(in.next().split(",")).mapToInt(Integer::parseInt).toArray();
            }
            boolean[][] used=new boolean[m][n];
            boolean dfs = dfs(g, 0, 0, 100, used);
            if(!dfs){
                System.out.println(-1);
                continue;
            }
            int left=0;
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
        if(g[x][y]==-1){
            total=100;
        }else {
            total=total-g[x][y];
        }
        used[x][y]=true;
        boolean result = dfs(g, x+1, y, total, used)
                ||dfs(g, x-1, y, total, used)
                || dfs(g, x, y+1, total, used)
                ||dfs(g, x, y-1, total, used);
        used[x][y]=false;
        total=temp;
        return result;
    }

}
package huaweiC200;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW16FOUR {
    static int[][] route={{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String source = in.next();
        String[] split = source.split(",");
        int m=Integer.parseInt(split[0]);
        int n=Integer.parseInt(split[1]);
        int[][] g=new int[m][n];
        for (int i = 0; i < m; i++) {
            g[i]= Arrays.stream(in.next().split(",")).mapToInt(Integer::parseInt).toArray();
        }
        boolean dfs = check(g, 100,g.length,g[0].length );
        if(!dfs){
            System.out.println(-1);
            return;
        }
        int left=0;
        int right=100;
        int ans=right;
        while (left<right){
            int middle=(left+right)/2;
            if( check(g,middle,g.length,g[0].length)){
                ans=middle;
                right=middle;
            }else {
                left=middle+1;

            }
        }
        System.out.println(ans);


    }
    public static boolean check(int[][] mp, int mid, int n, int m) {
        int[][] dis = new int[n][m];  // 存储距离的数组
        boolean[][] vis = new boolean[n][m];  // 存储访问标记的数组
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], -1);
        }
        dis[0][0] = mid - mp[0][0];
        if (mp[0][0] == -1) {
            dis[0][0] = 100;
        } else if (mp[0][0] == 0 || dis[0][0] < 0) {
            return false;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);  // 使用优先队列存储状态
        q.offer(new int[] {dis[0][0], 0, 0});  // 将初始状态加入队列
        int[] tx = {0, 1, 0, -1};  // x 方向的偏移量
        int[] ty = {1, 0, -1, 0};  // y 方向的偏移量
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int w = cur[0], x = cur[1], y = cur[2];
            if (vis[x][y]) {
                continue;
            }
            vis[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int xx = x + tx[i], yy = y + ty[i], ww = 0;
                if (xx >= 0 && xx < n && yy >= 0 && yy < m && mp[xx][yy] != 0 && !vis[xx][yy] && mp[xx][yy] <= w) {
                    if (mp[xx][yy] == -1) {
                        ww = 100;
                    } else {
                        ww = w - mp[xx][yy];
                    }
                    if (ww > dis[xx][yy]) {
                        dis[xx][yy] = ww;
                        q.offer(new int[] {dis[xx][yy], xx, yy});
                    }
                }
            }
        }
        return vis[n - 1][m - 1];
    }
}

package LC;
//有问题 但测试过

import java.util.ArrayDeque;

public class LC200TWO {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        if(grid==null){
            return 0;
        }
            m=grid.length;
            n=grid[0].length;
            int count=0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j]=='1'){
                        count++;
                        bfs(grid,i,j);
                    }
                }
            }
          return count;
    }
    public void bfs(char[][] grid,int x,int y) {
        if(x<0||y<0||x>=m||y>=n||grid[x][y]=='0'){
            return;
        }
        ArrayDeque<int[]> deque=new ArrayDeque<>();
        deque.offerLast(new int[]{x,y});
        grid[x][y]='0';
        while (!deque.isEmpty()){
            int[] temp = deque.pollFirst();
            bfs(grid,temp[0]+1,temp[1]);
            bfs(grid,temp[0]-1,temp[1]);
            bfs(grid,temp[0],temp[1]+1);
            bfs(grid,temp[0],temp[1]-1);
        }
    }




}

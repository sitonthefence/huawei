package LC;

//有问题
import java.util.ArrayDeque;

public class LC200THREE {
    int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
    int m;
    int n;
    boolean [][] used;
    public int numIslands(char[][] grid) {
        if(grid==null){
            return 0;
        }
        m=grid.length;
        n=grid[0].length;
        used=new boolean[grid.length][grid[0].length];
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!used[i][j]&&grid[i][j]=='1'){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid,int x,int y) {
        ArrayDeque<int[]> deque=new ArrayDeque<>();
        deque.offerLast(new int[]{x,y});
        used[x][y]=true;
        while (!deque.isEmpty()){
            int[] temp = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                x=direction[i][0]+temp[0];
                y=direction[i][1]+temp[1];
                if (x>=0&&y>=0&&x<m&&y<n&&!used[x][y]&&grid[x][y]=='1'){
                    deque.offerLast(new int[]{x,y});
                    used[x][y]=true;
                }
            }
        }
    }


}

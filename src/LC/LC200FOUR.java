package LC;

public class LC200FOUR {
   boolean [][] visited;
    int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
    int m;
    int n;
    int count;
    public int numIslands(char[][] grid){
        m=grid.length;
        n=grid[0].length;
        visited=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]==false&&grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int x,int y){
        if(x<0||y<0||x>=m||y>=n||grid[x][y]=='0'||visited[x][y]){
            return;
        }
        visited[x][y]=true;
        for (int i = 0; i < 4; i++) {
            dfs(grid,x+direction[i][0],y+direction[i][1]);
        }
    }


}

package LC;

public class LC1020 {

    int m;
    int n;
    public int numEnclaves(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||i==m-1||j==0||j==n-1){
                    dfs(grid,i,j);
                }
            }

        }
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid,int i,int j){
        if(i<0||j<0||i>=m||j>=n||grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);

    }
}

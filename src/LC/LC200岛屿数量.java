package LC;

public class LC200岛屿数量 {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int count=0;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(grid[i][j]=='1'){
                    count++;
                  dfs(grid,i,j);
                }
            }
        }
        return count;

    }
    public void dfs(char[][] grid,int i,int j){
           if(i<0||j<0||i>=m||j>=n||grid[i][j]=='0'){
               return;
           }
           grid[i][j]='0';
           dfs(grid,i+1,j);
           dfs(grid,i-1,j);
          dfs(grid,i,j+1);
          dfs(grid,i,j-1);
    }
}

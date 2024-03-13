package LC;

public class LC695岛屿的最大面积 {
    int m;
    int n;


    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
            m=grid.length;
            n=grid[0].length;
            int max=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                if(grid[i][j]==1){
                    max=Math.max(AreaOfIsland(grid,i,j),max);
                }
            }
        }
        return max;
    }
    public int AreaOfIsland(int[][] grid,int i,int j){
        if(i<0||j<0||i>=m||j>=n||grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        return 1+AreaOfIsland(grid,i+1,j)
                +AreaOfIsland(grid,i-1,j)
                +AreaOfIsland(grid,i,j+1)
                +AreaOfIsland(grid,i,j-1);

    }






}

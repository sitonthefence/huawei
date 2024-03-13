package LC;

public class LC463岛屿的周长 {
    public int islandPerimeter(int[][] grid) {
        int num=0;
        int border=0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    num++;
                    if(i-1>=0&&grid[i-1][j]==1) border++;
                    if (j-1>=0&&grid[i][j-1]==1) border++;
                }


            }
        }
        return 4*num-border*2;

    }
}

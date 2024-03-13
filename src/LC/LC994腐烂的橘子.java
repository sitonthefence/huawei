package LC;

import java.util.ArrayDeque;

public class LC994腐烂的橘子 {
    static int[][] route={{1,0},{-1,0},{0,-1},{0,1}};

    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> deque=new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==2){
                    deque.add(new int[]{i,j});
                }
            }
        }
         int count=-1;
        while (!deque.isEmpty()){
            count++;
              int size=deque.size();
            for (int i = 0; i < size; i++) {
                int[] ints = deque.pollFirst();
                int x = ints[0];
                int y = ints[1];
                for (int j = 0; j <4 ; j++) {
                 int newX=x+route[j][0];
                 int newY=y+route[j][1];
                 if(newX>=0&&newX<grid.length&&newY>=0&&newY<grid[0].length&&grid[newX][newY]==1){
                     grid[newX][newY]=2;
                     deque.add(new int[]{newX,newY});
                 }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        if(count==-1) return 0;
        return count;

    }
}

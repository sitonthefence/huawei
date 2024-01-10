package huaweiC200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m=in.nextInt();
            int n=in.nextInt();
            int[][] g=new int[m][n];
            List<int []> person=new ArrayList<>();
            List<int []>  terminal=new ArrayList<>();
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j]=in.nextInt();
                    if(g[i][j]==2){
                        person.add(new int[]{i,j});
                }
                    if ((g[i][j]==3)){
                        terminal.add(new int[]{i,j});
                    }
            }
            }
            boolean[][] used=new boolean[m][n];

            int count=0;
            for (int i = 0; i < terminal.size(); i++) {
                Boolean[][] memo1=new Boolean[m][n];
                Boolean[][] memo2=new Boolean[m][n];


                if(
                        dfs(g, person.get(0)[0], person.get(0)[1], terminal.get(i)[0], terminal.get(i)[1],used,memo1)

                                &&dfs(g, person.get(1)[0], person.get(1)[1], terminal.get(i)[0], terminal.get(i)[1],used,memo2)

                ){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    public static boolean dfs( int[][] g,int startX,int startY,int endX,int endY,  boolean[][] used,Boolean[][] memo){
        if(startX<0||startY<0||startX>=g.length||startY>=g[0].length||g[startX][startY]==1||used[startX][startY]){
            return false;
        }
        if(startX==endX&&startY==endY){
            return true;
        }
        if(memo[startX][startY]!=null){
            return memo[startX][startY];
        }
        used[startX][startY]=true;
        boolean dfs1 = dfs(g, startX + 1, startY, endX, endY, used,memo);
        boolean dfs2 = dfs(g, startX - 1, startY, endX, endY, used,memo);
        boolean dfs3 = dfs(g, startX, startY + 1, endX, endY, used,memo);
        boolean dfs4 = dfs(g, startX, startY - 1, endX, endY, used,memo);
        used[startX][startY]=false;
        memo[startX][startY]=dfs1||dfs2||dfs3||dfs4;
        return memo[startX][startY];



    }
}

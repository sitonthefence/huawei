package huaweiAB200;

import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] arr=new int[m][n];
            int totalBarriers=in.nextInt();
            for (int i = 0; i < totalBarriers; i++) {
                arr[in.nextInt()][in.nextInt()]=1;
            }
            arr[m-1][n-1]=3;
            dfs(0,0,arr);
            int unReachConut=0;
            int barrieCount=0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j]==-1){
                        barrieCount++;
                    }
                    if(arr[i][j]==0){
                        unReachConut++;
                    }

                }

            }
            System.out.print(barrieCount+" "+unReachConut);

        }
    }
    public static boolean dfs(int x,int y,int[][] arr){
        if(x<0||y<0||x>=arr.length||y>=arr[0].length||arr[x][y]==1){
            return false;
        }
        if(arr[x][y]==3){
            return true;
        }
        boolean dfs1 = dfs(x + 1, y, arr);
        boolean dfs2 = dfs(x, y + 1, arr);
        if(!dfs1&&!dfs2){
            arr[x][y]=-1;
            return false;
        }
        arr[x][y]=2;
        return true;
    }
}

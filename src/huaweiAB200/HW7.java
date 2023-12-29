package huaweiAB200;

import java.util.Scanner;

public class HW7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            if(!source.contains("1")||!source.contains("0")){
                System.out.println(-1);
                continue;
            }
            String[] split = source.split(",");
            int n= (int) Math.sqrt(split.length);
            int[][] g=new int[n][n];
            int index=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Integer.valueOf(split[index]);
                    index++;
                }
            }
            int days=0;
            while (!isAllInfect(g)){
                int [][] temp= new int[n][n];
                for (int i = 0; i <n ; i++) {
                    for (int j = 0; j < n; j++) {
                        temp[i][j]=g[i][j];
                    }
                }
                for (int i = 0; i <n ; i++) {
                    for (int j = 0; j < n; j++) {
                        if(g[i][j]==1){
                            if(i-1>0){
                                temp[i-1][j]=1;
                            }
                            if(j+1<n){
                                temp[i][j+1]=1;
                            }
                            if(i+1<n){
                                temp[i+1][j]=1;
                            }
                            if(j-1>0){
                                temp[i][j-1]=1;
                            }

                        }
                    }
                }
                g=temp;
                days++;
            }
            System.out.println(days);
        }


    }
    public static boolean isAllInfect(int[][] g){
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {

                if (g[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
}

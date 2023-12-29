package huaweiAB100;

import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m=in.nextInt();
            int n=in.nextInt();
            int[][] arr=new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j]=in.nextInt();
                }
            }
            int [][] result=new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j]==1){
                        result[i][j]=1;
                        if(i-1>=0){
                           result[i-1][j]=1;
                        }
                        if(j+1<n){
                            result[i][j+1]=1;
                        }
                        if(i+1<m){
                            result[i+1][j]=1;
                        }
                        if(j-1>=0){
                            result[i][j-1]=1;
                        }
                    }

                }
            }
            int count=0;
            for (int i = 0; i < m; i++) {

                for (int j = 0; j < n; j++) {
                    if(result[i][j]==1){
                        count++;
                    }

                }
            }
            System.out.println(count);









        }

    }
}

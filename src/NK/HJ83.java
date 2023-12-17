package NK;

import java.util.Scanner;

public class HJ83 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m= in.nextInt();
            int n=in.nextInt();
            int x1=in.nextInt();
            int y1=in.nextInt();
            int x2=in.nextInt();
            int y2=in.nextInt();
            int x=in.nextInt();
            int y=in.nextInt();
            int x3=in.nextInt();
            int y3=in.nextInt();
            if(m>9||n>9){
                System.out.println(-1);
                System.out.println(-1);
                System.out.println(-1);
                System.out.println(-1);
                System.out.println(-1);
                break;
            }else {
                System.out.println(0);
            }
            int[][] arr= new int[m][n];
            try {
                int t=arr[x1][y1];
                arr[x1][y1]=arr[x2][y2];
                arr[x2][y2]=t;
                System.out.println(0);
            } catch (Exception e) {
                System.out.println(-1);
            }

            if(m+1>9||x>=m){
                System.out.println(-1);
            }else {
                System.out.println(0);
            }
            if(n+1>9||y>=n){
                System.out.println(-1);
            }else {
                System.out.println(0);
            }

            try {
                int i = arr[x3][y3];
                System.out.println(0);
            } catch (Exception e) {
                System.out.println(-1);
            }


        }
    }
}

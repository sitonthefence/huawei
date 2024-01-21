package huaweiC200;

import java.util.Scanner;

public class HW60 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int  column= in.nextInt();
            int row = in.nextInt();
            int y = in.nextInt();
            int x = in.nextInt();
            int sy = in.nextInt();
            int sx = in.nextInt();
            int t = in.nextInt();
            int[][] g=new int[row][column];
            for (int i = 0; i < row; i++) {
                String line = in.next();
                for (int j = 0; j < column; j++) {
                    g[i][j]=line.charAt(j)-'0';
                }
            }
            int count =0;
            if(g[x][y]==1){
                count++;
            }
            for (int i = 0; i < t; i++) {
                if(x+sx<0||x+sx>=row){
                    sx=-sx;
                }
                if(y+sy<0||y+sy>=column){
                    sy=-sy;
                }
                x+=sx;
                y+=sy;
                if(g[x][y]==1){
                    count++;
                }

            }
            System.out.println(count);
        }


    }



}

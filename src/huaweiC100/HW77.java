package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW77 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int total = in.nextInt();
            int row=in.nextInt();
            int column=0;
            if(total%row==0){
                column=total/row;
            }else {
                column=total/row+1;
            }
            char [][] arr=new char[row][column];

            int[][] route={{0,1},{1,0},{0,-1},{-1,0}};
            int x=0;
            int y=0;
            int index=0;
            for (int i = 1; i <= total; i++) {
                arr[x][y]=String.valueOf(i).charAt(0);
                if(x+route[index][0]<0||y+route[index][1]<0||x+route[index][0]>=row||
                    y+route[index][1]>=column||arr[x+route[index][0]][y+route[index][1]]=='*'){
                    index=(index+1)%4;
                }
                    x=x+route[index][0];
                   y=y+route[index][1];
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if(arr[i][j]==0){
                        System.out.print('*'+" ");
                    }else {
                        System.out.print(arr[i][j]+" ");
                    }

                }
                System.out.println();
            }



        }
    }
}

package huaweiC100;

import java.util.Scanner;

public class HW77TWO {

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
                //错误 !!!!!!
                arr[x][y]=String.valueOf(i).charAt(0);
                x=x+route[index][0];
                y=y+route[index][1];
                if(x==0||y==0||x==row-1|| y==column-1||arr[x][y]=='*'){
                    index=(index+1)%4;
                }

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

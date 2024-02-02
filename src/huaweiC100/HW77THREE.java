package huaweiC100;

import java.util.Scanner;

public class HW77THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int row=in.nextInt();
        int column=0;
        if(number%row==0){
            column=number/row;
        }else {
            column=number/row+1;
        }
        int[][] result=new int[row][column];
        int currentX=0;
        int currentY=0;
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        int index=0;
        for (int i = 1; i <=number ; i++) {
            result[currentX][currentY]=i;
            if(currentX+dir[index][0]>=result.length
             || currentX+dir[index][0]<0
             ||currentY+dir[index][1]>=result[0].length
             ||currentY+dir[index][1]<0
             ||result[currentX+dir[index][0]][currentY+dir[index][1]]!=0){
                index=(index+1)%4;

            }
            currentX=currentX+dir[index][0];
            currentY=currentY+dir[index][1];
        }
        for (int i = 0; i <result.length ; i++) {
            for (int j = 0; j <result[0].length ; j++) {
                if(result[i][j]==0){
                    System.out.print("* ");
                }else {
                    System.out.print(result[i][j]+" ");
                }
            }
            System.out.println();
        }



    }


}

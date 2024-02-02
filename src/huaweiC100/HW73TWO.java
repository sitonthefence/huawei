package huaweiC100;

import java.util.Scanner;

public class HW73TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int row=Integer.valueOf(split[0]);
        int column=Integer.valueOf(split[1]);
        int [][] g=new int[row][column];
        int currentX=0;
        int currentY=0;
        for (int i = 1; i < split.length/2; i++) {
            int black=Integer.parseInt(split[2*i]);
            int length=Integer.parseInt(split[2*i+1]);
            for (int j = 0; j < length; j++) {
                g[currentX][currentY]=black;
                if(currentY+1>=g[0].length){
                    currentX++;
                    currentY=0;
                }else {
                    currentY++;
                }
            }
        }
        System.out.println(g[in.nextInt()][in.nextInt()]);



    }
}

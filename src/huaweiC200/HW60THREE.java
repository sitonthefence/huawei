package huaweiC200;

import java.util.Scanner;

public class HW60THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int column = in.nextInt();
        int row = in.nextInt();
        int y=in.nextInt();
        int x = in.nextInt();
        int speedY=in.nextInt();
        int speedX = in.nextInt();
        int totalTime = in.nextInt();
        int [][]g=new int[row][column];
        for (int i = 0; i <row ; i++) {
            String next = in.next();
            for (int j = 0; j < column; j++) {
                g[i][j]=next.charAt(j)-'0';
            }
        }
        int count=0;
        for (int i = 0; i <= totalTime; i++) {
            if(g[x][y]==1)  count++;
            if(x+speedX==-1||x+speedX== g.length){
                speedX=-speedX;
            }
            if(y+speedY==-1||y+speedY==g[0].length){
                speedY=-speedY;
            }
            x+=speedX;
            y+=speedY;
        }
        System.out.println(count);

    }
}

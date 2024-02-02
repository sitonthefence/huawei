package huaweiC100;

import java.util.Scanner;

public class HW62 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int E = in.nextInt();
        int [][] arr=new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0]=in.nextInt();
            arr[i][1]=in.nextInt();
        }
        int preX=0;
        int preY=0;
        int area=0;
        for (int i = 0; i < N; i++) {
            int curX=arr[i][0];
            int curY=arr[i][1]+preY;
            area+=(curX-preX)*Math.abs(preY);
            preX=curX;
            preY=curY;
        }
        area+=(E-preX)*Math.abs(preY);
        System.out.println(area);
    }
}

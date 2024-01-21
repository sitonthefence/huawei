package huaweiAB100;

import java.util.Scanner;

//正确

public class HW97TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int t = in.nextInt();
        int x_dir=1;
        int y_dir = 1;
        int x_Boundary=800-50;
        int y_Boundary=600-25;
        for (int i = 0; i < t; i++) {

            if(x+x_dir>x_Boundary||x+x_dir<0){
                x_dir*=-1;
            }
            if(y+y_dir>y_Boundary||y+y_dir<0){
                y_dir*=-1;
            }
            x+=x_dir;
            y+=y_dir;
        }
        System.out.println(x+" "+y);
    }
}

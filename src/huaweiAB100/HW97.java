package huaweiAB100;

import java.util.Scanner;

public class HW97 {
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
            x+=x_dir;
            y+=y_dir;
            if(x==x_Boundary||x==0){
                x_dir*=-1;
            }
            if(y==y_Boundary||y==0){
                y_dir*=-1;
            }
        }
        System.out.println(x+" "+y);
    }

}

package NK;

import java.util.Scanner;

public class H38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextDouble()){
            double source = in.nextDouble();
            double x1=source;
            double total=x1+x1;
            double h=1.0/4*source;
            for (int i = 3; i <=5; i++) {
                source=source/2;
                total=total+source;
                h=1.0/2*h;
            }
            System.out.println(total);
            System.out.println(h);

        }


    }


}

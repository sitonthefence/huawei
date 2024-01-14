package huaweiC200;

import java.util.Scanner;

public class HW68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int carNum = in.nextInt();
            int distance = in.nextInt();
            double ans=0;
            for (int i = 0; i < carNum; i++) {
                double t=(double)distance/in.nextInt();
                if(i==0||t>=ans-1){
                    ans=t;
                }else {
                    ans=ans-1;
                }
            }
            System.out.println(ans);
        }
    }


}

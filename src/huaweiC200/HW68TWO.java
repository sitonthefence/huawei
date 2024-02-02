package huaweiC200;

import java.text.NumberFormat;
import java.util.Scanner;

public class HW68TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int vehicleNum = in.nextInt();
        double distance = in.nextInt();
        int[] speed=new int[vehicleNum];
        for (int i = 0; i < vehicleNum; i++) {
            speed[i]=in.nextInt();
        }
        NumberFormat instance = NumberFormat.getInstance();
        instance.setMinimumFractionDigits(0);
        instance.setMaximumFractionDigits(3);

        if (vehicleNum==1){
        System.out.println(instance.format(distance/speed[0]));
        return;
       }
       double preAnswer=distance/speed[0];
       double curAnswer=0;
        for (int i = 1; i <vehicleNum ; i++) {
            if(distance/speed[i]<=preAnswer-1){
                curAnswer=preAnswer-1;
            }else {
                curAnswer=distance/speed[i];

            }
            preAnswer=curAnswer;
        }
        System.out.println(instance.format(curAnswer));
    }
}

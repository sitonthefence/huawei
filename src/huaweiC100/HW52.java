package huaweiC100;

import java.util.Scanner;

public class HW52 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int source = in.nextInt();
            int target = in.nextInt();
            int jinzhi=in.nextInt();
            int count =0;
            while (source>0){
                if(source%jinzhi==target){
                    count++;
                }
                 source= source / target;

            }
            System.out.println(count);
        }

    }

}

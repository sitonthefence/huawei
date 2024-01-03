package huaweiC100;

import java.util.Scanner;

public class HW61 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String source1 = source.replace(",", "");
            String source2 = source1.replace("111", "");
            int bigCar=(source1.length()-source2.length())/3;
            String source3 = source2.replace("11", "");
            int middleCar=(source2.length()-source3.length())/2;
            String source4 = source3.replace("1", "");
            int smallCar=source3.length()-source4.length();
            System.out.println(bigCar+middleCar+smallCar);


        }

    }
}

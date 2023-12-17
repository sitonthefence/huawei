package NK;

import java.util.Calendar;
import java.util.Scanner;

public class HJ73 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt();
            Calendar calendar = Calendar.getInstance();
            calendar.set(year,month-1,day);
            int i = calendar.get(Calendar.DAY_OF_YEAR);
            System.out.println(i);


        }


    }





}

package NK;

import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] split = s.split("\\;");
            int a = 0;
            int b = 0;
            for (String temp : split) {
                if (temp.matches("[ASWD]\\d{1,2}")) {
                    if (temp.charAt(0) == 'A') {
                        String substring = temp.substring(1);
                        Integer integer = Integer.valueOf(substring);
                        a = a - integer;
                    } else if (temp.charAt(0) == 'D') {
                        String substring = temp.substring(1);
                        Integer integer = Integer.valueOf(substring);
                        a = a + integer;
                    } else if (temp.charAt(0) == 'W') {
                        String substring = temp.substring(1);
                        Integer integer = Integer.valueOf(substring);
                        b = b + integer;
                    } else {
                        String substring = temp.substring(1);
                        Integer integer = Integer.valueOf(substring);
                        b = b - integer;
                    }

                }

            }
            System.out.println(a+","+b);
        }


    }


}

package huaweiAB100;

import java.util.Scanner;

public class HW26 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int N = in.nextInt();
            String a = in.next();
            String b = in.next();
            int a0=0;
            int a1=0;
            int a1b0=0;
            int a0b0=0;
            for (int i = 0; i < N; i++) {
                if(a.charAt(i)=='0'){
                    a0++;{
                        if (b.charAt(i)=='0')
                            a0b0++;

                    }
            }
                if(a.charAt(i)=='1'){
                    a1++;
                    if (b.charAt(i)=='0')
                        a1b0++;

            }
        }
            System.out.println(a1b0*a0+a1*a0b0-a1b0*a0b0);


    }
}
}


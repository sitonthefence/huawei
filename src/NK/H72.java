package NK;

import java.util.Scanner;

public class H72 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            in.nextInt();
            for (int i = 0; i <= 20; i++) {
                for (int j = 0; j <= 33; j++) {
                    for (int k = 0; k <= 100; k=k+3) {
                    if((i+j+k==100)&&(5*i+3*j+k/3)==100){
                            System.out.println(i+" "+j+" "+(int)k);

                        }

                    }

                }

            }




        }


    }
}

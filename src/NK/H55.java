package NK;

import java.util.Scanner;

public class H55 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int source = in.nextInt();
            int num=0;
            for (int i = 1; i <=source; i++) {
                if(String.valueOf(i).contains("7")||i%7==0){
                    num++;

                }
            }
            System.out.println(num);


        }


    }

}

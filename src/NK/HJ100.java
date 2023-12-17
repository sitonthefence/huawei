package NK;

import java.sql.Array;
import java.util.Scanner;

public class HJ100 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int [] array= new int[length];
            int sum=0;
            sum=array[0]=2;
            for (int i = 1; i < array.length; i++) {
                array[i]=array[i-1]+3;
                sum+=array[i];
            }
            System.out.println(sum);



        }

    }




}

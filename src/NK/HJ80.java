package NK;

import java.util.Scanner;
import java.util.TreeSet;

public class HJ80 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        TreeSet<Integer> set=new TreeSet<>();
        int num1=in.nextInt();
         int []  array1=new int[num1];
        for (int i = 0; i < num1; i++) {
            array1[i]=in.nextInt();
            set.add(array1[i]);
        }
        int num2=in.nextInt();
        int []  array2=new int[num2];
        for (int i = 0; i < num2; i++) {
            array2[i]=in.nextInt();
            set.add(array2[i]);
        }
        for (Integer temp:
             set) {
            System.out.print(temp);

        }








    }

}

package NK;

import java.util.Scanner;

public class HJ76 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int [][] array=new int[length][length];
            int init=-1;
            for (int i=0;i<length;i++){
                for (int j = 0; j <=i; j++) {
                     init = init +2;
                    array[i][j]=init;
                }
            }
            for (int i = 0; i < length-1; i++) {
                System.out.print(array[length-1][i]+"+");
            }
            System.out.print(array[length-1][length-1]);

        }
    }


}

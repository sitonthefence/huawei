package NK;

import java.util.Scanner;

public class HJ37 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int source = in.nextInt();
            int [] array=new int[source];

            if (source==1){


                System.out.println(1);
            }

            if(source==2){

                System.out.println(1);

            }

            if (source>2) {

                array[0]=1;
                array[1]=1;
                for (int i = 2; i < source ; i++) {
                    array[i] = array[i - 2] + array[i - 1];

                }
                System.out.println(array[source-1]);
            }





        }

    }


}

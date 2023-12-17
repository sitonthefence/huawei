package NK;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ51 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while(in.hasNextInt()){
            int length = in.nextInt();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<length;i++){

                list.add(in.nextInt());

            }
            System.out.println(list.get(length - in.nextInt()));

        }



    }
}

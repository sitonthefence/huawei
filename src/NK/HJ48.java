package NK;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ48 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            List<Integer> list=new ArrayList<>();
            list.add(in.nextInt());
            for (int i = 0; i <length-1 ; i++) {
                int value = in.nextInt();
                int target = in.nextInt();
                list.add(list.indexOf(target)+1,value);
            }
            int removeNumber = in.nextInt();
            list.remove(list.indexOf(removeNumber));
            list.forEach(tempt-> System.out.print(tempt+" "));

        }


    }


}

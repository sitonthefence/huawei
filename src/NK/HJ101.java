package NK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ101 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(in.nextInt());
        }
        int isAsc = in.nextInt();
        if(isAsc==0){
            Collections.sort(list);

        }else {
            Collections.sort(list,((o1, o2) ->o2.intValue()-o1.intValue()));
        }
        for (Integer temp:
        list) {
            System.out.print(temp+" ");

        }


    }



}

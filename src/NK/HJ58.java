package NK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int a = in.nextInt();
            int b = in.nextInt();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i <a; i++) {
                list.add(in.nextInt());
            }
            Collections.sort(list);
            for (int i = 0; i < b; i++) {
                System.out.print(list.get(i)+" ");
            }
        }
    }
}

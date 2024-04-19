package NK;

import java.util.*;

public class H14 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int length = in.nextInt();

        List<String> list=new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(in.next());
        }
        Collections.sort(list);
        for (String s:
             list) {
            System.out.println(s);
        }


    }
}

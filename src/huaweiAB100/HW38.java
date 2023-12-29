package huaweiAB100;

import java.util.*;

public class HW38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            List<String> list=new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                list.add(split[i]);
            }
           list.sort(((o1, o2) ->
           o1.length()-o2.length()));
            List<String> list1=new ArrayList<>();


            for (int i = 0; i < 3; i++) {
              list1.add(list.get(i));
            }
            Collections.sort(list1);
            for (int i = 0; i < 3; i++) {
                System.out.print(list1.get(i));
            }



        }
    }



}

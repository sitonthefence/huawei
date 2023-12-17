package huawei100;

import java.util.*;

public class HW25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String source = in.nextLine();
            String target = in.nextLine();
            String[] split = source.split("[^a-zA-Z]+");
            List<String> list = Arrays.asList(split);
            HashSet set = new LinkedHashSet(list);
            List<String> listPool = new ArrayList<>(set);
            Collections.sort(listPool);
            for (int i = 0; i < listPool.size(); i++) {
      /*          String regex=target+"[a-zA-Z]*";
                if(listPool.get(i).matches(regex)){
                    System.out.print(listPool.get(i)+" ");

                }*/
                if (listPool.get(i).startsWith("f")) {
                    System.out.print(listPool.get(i) + " ");

                }
            }

        }





    }


}

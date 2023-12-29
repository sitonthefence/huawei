package huaweiAB100;

import java.util.*;

public class HW89 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            Map<String,Integer> map=new HashMap<>();
            for (int i = 0; i < split.length; i++) {
                map.put(split[i], map.getOrDefault(split[i],0)+1);
            }
            Collection<Integer> values = map.values();
            List<Integer> list=new ArrayList<>(values);
            list.sort(((o1, o2) -> o2.intValue()-o1.intValue()));
            int sum=0;
            int result=0;
            for (int i = 0; i < list.size(); i++) {
                result++;
                 sum=sum+list.get(i);
                       if (sum>split.length/2){
                           break;
                       }
            }

            System.out.println(result);



        }


    }







}

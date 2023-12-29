package huaweiAB200;

import java.util.*;

public class HW54 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source1 = in.next();
            String[] split1 = source1.split(",");
            Map<Integer,Integer> map1=new HashMap<>();
            for (int i = 0; i < split1.length; i++) {
                map1.put(Integer.valueOf(split1[i]), map1.getOrDefault(Integer.valueOf(split1[i]),0)+1);
            }
            String source2 = in.next();
            String[] split2 = source2.split(",");
            Map<Integer,Integer> map2=new HashMap<>();
            for (int i = 0; i < split2.length; i++) {
                map2.put(Integer.valueOf(split2[i]), map2.getOrDefault(Integer.valueOf(split2[i]),0)+1);
            }
            Map<Integer,Set<Integer>> map=new TreeMap<>();
            for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
                for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
                    if(entry1.getKey()==entry2.getKey()){
                        int min = Math.min(entry1.getValue(), entry2.getValue());
                        if(!map.containsKey(min)){
                             Set<Integer> set=new TreeSet<>();
                             set.add(entry1.getKey());
                             map.put(min,set);
                         }else {
                             Set<Integer> set = map.get(min);
                             set.add(entry1.getKey());
                         }
                        break;
                    }
                }
            }

           if(map.isEmpty()){
               System.out.println("NULL");
               continue;
           }

            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(entry.getKey()+":");
                for (Integer integer : entry.getValue()) {
                    stringBuilder.append(integer+",");
                }
                System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
            }


        }
    }
}

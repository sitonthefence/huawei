package huaweiC100;

import java.util.*;

public class HW16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            Map<Integer,Integer> map=new LinkedHashMap<>();
            for (int i = 0; i < split.length; i++) {
                map.put(Integer.valueOf(split[i]),map.getOrDefault(Integer.valueOf(split[i]),0)+1);
            }
            LinkedList<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
            Collections.sort(entries,(o1,o2)->o2.getValue()-o1.getValue());
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < entries.size(); i++) {
                stringBuilder.append(entries.get(i).getKey()+",");
            }
            String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
            System.out.println(substring);
        }
    }

}

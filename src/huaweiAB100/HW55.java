package huaweiAB100;

import java.util.*;

public class HW55 {

    public static Map<String,Integer> map=new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            if(source.matches("[0-9]+")){
                LinkedList<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
                entries.sort(((o1, o2) ->
                        {
                            if(o1.getValue()== o2.getValue()){
                                return o1.getKey().compareTo(o1.getKey());
                            }else {
                                return o2.getValue()-o1.getValue();
                            }
                        }
                        )
                );
                StringBuilder stringBuilder=new StringBuilder();
                for (int i = 0; i < Integer.valueOf(source); i++) {
                    stringBuilder.append(entries.get(i).getKey()).append(",");

                }
                String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
                System.out.println(substring);

            }else {
                map.put(source, map.getOrDefault(source,0)+1);
            }
        }
    }
}

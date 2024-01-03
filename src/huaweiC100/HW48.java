package huaweiC100;

import java.util.*;

public class HW48 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, TreeSet<String>> map=new HashMap<>();

        while (in.hasNext()){
            String value = in.next();
            String key = in.next();
           if(map.containsKey(key)){
               map.get(key).add(value);
           }else {
               TreeSet<String> treeSet=new TreeSet<>();
               treeSet.add(value);
               map.put(key,treeSet);
           }
        }
        if(map.size()==1||map.size()==3){
            System.out.println("NULL");
        }else {
            Set<String> set = map.keySet();
            if(set.contains("A")&&set.contains("B")){
                for (int i = 0; i <map.get("A").size() ; i++) {
                    LinkedList<String> a = new LinkedList<>(map.get("A"));
                    System.out.println(a.get(i));
                }
            }else if(set.contains("B")&&set.contains("C")) {
                for (int i = 0; i < map.get("B").size(); i++) {
                    LinkedList<String> b = new LinkedList<>(map.get("B"));
                    System.out.println(b.get(i));
                }
            }else {
                for (int i = 0; i < map.get("C").size(); i++) {
                    LinkedList<String> c = new LinkedList<>(map.get("C"));
                    System.out.println(c.get(i));
                }
            }



        }


    }
}

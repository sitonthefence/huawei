package huaweiC200;

import java.util.*;

public class HW55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            Map<String, List<String>> next=new HashMap<>();
            Map<String,Integer> inDegree=new HashMap<>();
            HashSet<String> node=new HashSet<>();
            List<String> result=new ArrayList<>();
            String source = in.nextLine();
            String[] split = source.split(" ");
            for (int i = 0; i < split.length; i++) {
                String[] dependence = split[i].split("->");
                String a=dependence[0];
                String b=dependence[1];
                node.add(a);
                node.add(b);
                //putIfAbsent
                next.putIfAbsent(b,new ArrayList<>());
                next.get(b).add(a);
                //put getordefault
                inDegree.put(a,inDegree.getOrDefault(a,0)+1);
            }
            LinkedList<String> deque=new LinkedList<>();
            for (String s : node) {
                if(!inDegree.containsKey(s)){
                    deque.add(s);
                }
            }
            while (!deque.isEmpty()){
                //排序逻辑在这里
                Collections.sort(deque);
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    String fa = deque.pollFirst();
                    result.add(fa);
                    if(next.containsKey(fa)){
                        for (String s : next.get(fa)) {
                            inDegree.put(s,inDegree.get(s)-1);
                            if(inDegree.get(s)==0){
                                deque.add(s);
                            }
                        }
                    }
                }
            }
            for (String s : result) {
                System.out.print(s+" ");
            }
        }
    }
}

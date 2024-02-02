package huaweiC200;

import java.util.*;

public class HW55TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, List<String>> sheet=new HashMap<>();
        Map<String,Integer> inDegree=new HashMap<>();
        HashSet<String> manage=new HashSet<>();
        String[] split = in.nextLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            String[] dependency = split[i].split("->");
            String a=dependency[0];
            String b=dependency[1];
            manage.add(a);
            manage.add(b);
            inDegree.put(a,inDegree.getOrDefault(a,0)+1);
            sheet.putIfAbsent(b,new ArrayList<>());
            sheet.get(b).add(a);
        }
        LinkedList<String> deque=new LinkedList<>();
        for (String work : manage) {
            if(!inDegree.containsKey(work)){
                deque.add(work);
            }
        }
        List<String> result=new ArrayList<>();

        while (!deque.isEmpty()){
            Collections.sort(deque);
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String fa = deque.pollFirst();
                result.add(fa);
                 if(sheet.containsKey(fa)){
                     for (String s : sheet.get(fa)) {
                         inDegree.put(s,inDegree.get(s)-1);
                         if(inDegree.get(s)==0){
                             deque.offerLast(s);
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

package huaweiC200;

import java.util.*;

public class HW49TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        Map<Integer, List<Integer>> sheet=new HashMap<>();
        Map<Integer,Integer> inDegree=new HashMap<>();
        HashSet<Integer> point=new HashSet<>();
        for (int i = 0; i < length; i++) {
            int a=in.nextInt();
            int b=in.nextInt();
            point.add(a);
            point.add(b);
            inDegree.put(b,inDegree.getOrDefault(b,0)+1);
            sheet.putIfAbsent(a,new ArrayList<>());
            sheet.get(a).add(b);
        }
        int begin=-1;
        for (Integer each : point) {
            if(!inDegree.containsKey(each)){
                begin=each;
                break;
            }
        }
        List<Integer> endList=new ArrayList<>();
        for (Integer each : point) {
            if(!sheet.containsKey(each)){
                endList.add(each);
            }
        }
        Collections.sort(endList,(o1,o2)->o2-o1);
        ArrayDeque<Integer>  deque=new ArrayDeque<>();
        deque.add(begin);
        int count=1;
        while (!deque.isEmpty()){
            Integer father = deque.pollFirst();
             if(sheet.containsKey(father)){
                 List<Integer> childList = sheet.get(father);
                 for (Integer child : childList) {
                     inDegree.put(child,inDegree.get(child)-1);
                     if(inDegree.get(child)==0){
                         deque.offerLast(child);
                         count++;
                     }
                 }
             }
        }
        if(count!=point.size()){
            System.out.println(-1);
        }else {
            System.out.print(begin+" ");
            for (Integer integer : endList) {
                System.out.print(integer+" ");
            }
        }

    }
}

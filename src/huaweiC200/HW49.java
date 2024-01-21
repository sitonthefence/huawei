package huaweiC200;

import java.util.*;

public class HW49 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int nodeCount = in.nextInt();
            //节点不是从0开始，特殊
            Map<Integer, List<Integer>> next=new HashMap<>();
            Map<Integer,Integer> inDegree=new HashMap<>();
            //无法用fori，只能用增强for
            HashSet<Integer> node=new HashSet<>();
            for (int i = 0; i < nodeCount; i++) {
                int a=in.nextInt();
                int b=in.nextInt();
                node.add(a);
                node.add(b);
              inDegree.put(b,inDegree.getOrDefault(b,0)+1);
                next.putIfAbsent(a,new ArrayList<>());
                next.get(a).add(b);
            }
            int head=0;
            ArrayDeque<Integer> deque=new ArrayDeque<>();
            int count=0;
            for (Integer integer : node) {
                if(!inDegree.containsKey(integer)){
                    head=integer;
                    deque.add(head);
                    count++;
                    break;
                }
            }
            ArrayList<Integer> tail=new ArrayList<>();
            for (Integer integer : node) {
                if(!next.containsKey(integer)){
                    tail.add(integer);
                }
            }
            while (!deque.isEmpty()){
                Integer fa = deque.pollFirst();
                if (next.containsKey(fa)){
                    for (Integer child : next.get(fa)) {
                        inDegree.put(child,inDegree.get(child)-1);
                        //保证不形成循环引用
                       if(inDegree.get(child)==0){
                           deque.add(child);
                           count++;
                       }
                    }
                }
            }
            if(count!=node.size()){
                System.out.println(-1);
            }else {
                System.out.print(head+" ");
                Collections.sort(tail);
                for (Integer integer : tail) {
                    System.out.print(integer+" ");
                }
            }

        }
    }
}

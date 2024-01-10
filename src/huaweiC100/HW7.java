package huaweiC100;

import java.util.*;

public class HW7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            int[] arr=new int[split.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=Integer.valueOf(split[i]);
            }
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
            Collection<Integer> values = map.values();
            int max=Integer.MIN_VALUE;
            for (Integer value : values) {
                max=Math.max(value,max);
            }
            List<Integer> list=new ArrayList<>();
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if(entry.getValue()==max){
                    list.add(entry.getKey());
                }
            }
            Collections.sort(list);
            int target=0;
            if(list.size()%2==0){
                target=(list.get(list.size()/2-1)+list.get(list.size()/2))/2;
            }else {
                target=list.get(list.size()/2);
            }
            System.out.println(target);



        }
    }
}

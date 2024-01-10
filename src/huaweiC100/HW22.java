package huaweiC100;

import java.util.*;

public class HW22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[] weight=new int[5];
            for (int i = 0; i <5 ; i++) {
                weight[i]=in.nextInt();
            }
            Map<String,Integer> map=new HashMap<>();
            for (int i = 0; i < length; i++) {
                map.put(in.next(),in.nextInt()*weight[0]+in.nextInt()*weight[1]+in.nextInt()*weight[2]
                        +in.nextInt()*weight[3]+in.nextInt()*weight[4]);
            }
            LinkedList<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
            Collections.sort(entries,(o1, o2) ->{
                if(o1.getValue().intValue()==o2.getValue().intValue() ){
                    return o1.getKey().toLowerCase().compareTo(o2.getKey().toLowerCase());
                }else {
                    return o2.getValue()-o1.getValue();
                }
                    }
                    );

            for (Map.Entry<String, Integer> entry : entries) {
                System.out.println(entry.getKey());
            }
        }
    }
}

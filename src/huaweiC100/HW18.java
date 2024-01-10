package huaweiC100;

import java.util.*;

public class HW18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i <length ; i++) {
                int temp=in.nextInt();
                map.put(temp,map.getOrDefault(temp,0)+1);
            }
            int target = in.nextInt();
            ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
            Collections.sort(entries,(o1,o2)->{
                if(o1.getValue().equals(o2.getValue())){
                    return o1.getKey()- o2.getKey();
                }else {
                    return o2.getValue()-o1.getValue();
                }
            });
            int count=0;
            for (int i = 0; i < entries.size(); i++) {
                if(entries.get(i).getValue()>=target){
                    count++;
                }
            }
            System.out.println(count);
            for (int i = 0; i < count; i++) {
                System.out.println(entries.get(i).getKey());
            }

        }
    }
}

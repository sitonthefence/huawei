package NK;

import java.util.*;

public class HJ68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int length = in.nextInt();
            int k= in.nextInt();
            Map<String,Integer> map=new LinkedHashMap<>();
            for (int i = 0; i < length; i++) {
                map.put(in.next(),in.nextInt());
            }
            ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            if(k==1){
                Collections.sort(list,(o1,o2)-> o1.getValue()-o2.getValue());

            }else {

                Collections.sort(list,(o1,o2)-> o2.getValue()-o1.getValue());
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getKey()+" "+list.get(i).getValue());
            }


        }
    }


}

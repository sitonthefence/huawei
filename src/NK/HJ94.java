package NK;

import java.util.*;

public class HJ94 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int personTotals=in.nextInt();
        Map<String,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i < personTotals; i++) {
            map.put(in.next(),0);
        }
        int voteTotals=in.nextInt();
        int invalid=0;
        for (int i = 0; i < voteTotals; i++) {
            String next = in.next();
            if(map.containsKey(next)){
                map.put(next,map.get(next)+1);
            }else {

                invalid++;
            }
        }
        for (String str:
             map.keySet()) {

            System.out.println(str+" : "+map.get(str));

        }
        System.out.println("Invalid : "+invalid);





    }


}

package NK;

import java.util.*;

public class HJ23 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.nextLine();

            char[] sourceArrays = source.toCharArray();
            Map<Character,Integer> map=new HashMap<>();
            for (Character c:sourceArrays
                 ) {
                map.put(c,(map.getOrDefault(c,0)+1));
            }
            int min=Integer.MAX_VALUE;
            for (Integer value : map.values()) {
                if(min>value){
                    min=value;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Character c:sourceArrays
                 ) {
                 if(map.get(c)!=min){

                     stringBuilder.append(c);
                 }

            }
            System.out.println(stringBuilder);

        }

    }
}

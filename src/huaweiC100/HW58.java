package huaweiC100;

import java.util.*;

public class HW58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            if(source.length()==0){
                System.out.println(-1);
                continue;
            }
            Map<Character,Integer> map=new HashMap<>();
            char currentChar = source.charAt(0);
            int count=1;
            for (int i = 1; i <source.length() ; i++) {
                if(source.charAt(i)==source.charAt(i-1)){
                    count++;
                }
                else {
                    currentChar=source.charAt(i);
                    count=1;
                }
                if(map.containsKey(currentChar)){
                   if(count>map.get(currentChar)){
                       map.put(currentChar,count);
                   };
                }else {
                    map.put(currentChar,count);
                }
            }
            int k = in.nextInt();
            ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
            Collections.sort(entries,(o1,o2)->o2.getValue()-o1.getValue());
            System.out.println(entries.get(k-1).getValue());

        }

    }
}

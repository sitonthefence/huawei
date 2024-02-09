package huaweiC100;

import java.util.*;

public class HW58TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.next();
        int k = in.nextInt();
        Map<Character,Integer> map=new HashMap<>();
        char currentChar=source.charAt(0);
        int count=1;
        map.put(currentChar,1);
        for (int i = 1; i < source.length(); i++) {
            if(source.charAt(i)==currentChar){
                count++;
                if(count>map.get(currentChar)){
                    map.put(currentChar,count);
                }
            }else {
                count=1;
                currentChar=source.charAt(i);
                map.putIfAbsent(currentChar,1);

            }
        }
        if(k>map.size()||k<=0){
            System.out.println(-1);
            return;
        }
        LinkedList<Map.Entry<Character, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries,(o1,o2)->o2.getValue()-o1.getValue());
        System.out.println(entries.get(k - 1).getValue());


    }


}

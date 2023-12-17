package huawei100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HW57 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String target = in.next();
            String source = in.next();
            Map<Character,Integer> targetMap=new HashMap<>();
            Map<Character,Integer> sourceMap=new HashMap<>();
            for (int i = 0; i < target.length(); i++) {
                targetMap.put(target.charAt(i),targetMap.getOrDefault(target.charAt(i),0)+1);
            }
            for (int i = 0; i < source.length(); i++) {
                sourceMap.put(source.charAt(i),sourceMap.getOrDefault(source.charAt(i),0)+1);
            }
            Set<Map.Entry<Character, Integer>> entries = targetMap.entrySet();
             boolean flag=true;
            for (Map.Entry<Character, Integer> entry : entries) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                if(sourceMap.containsKey(key)){
                    if(value>sourceMap.get(key)){
                        flag=false;
                        break;
                    }
                }else {
                    flag=false;
                    break;
                }

            }
            if(flag==false){
                System.out.println(-1);
                break;
            }



        }


    }
}

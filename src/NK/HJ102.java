package NK;

import java.util.Scanner;
import java.util.TreeMap;

public class HJ102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            TreeMap<Character,Integer> map=new TreeMap<>();
            for (int i = 0; i < source.length(); i++) {
               map.put(source.charAt(i), map.getOrDefault(source.charAt(i),0)+1);
            }
            int max=Integer.MIN_VALUE;
            for (Character temp:map.keySet()
                 ) {
                Integer integer = map.get(temp);
                if(integer>max){
                    max=integer;
                }
            }
           while (max>=1){
                for (Character temp:map.keySet()
                     ) {
                    if(map.get(temp)==max){
                        System.out.print(temp);
                    }
                }
            max--;
            }
        }
    }
}

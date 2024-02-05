package huaweiC200;

import java.util.*;

public class HW54TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] word = in.nextLine().split("[,.;]");
        String[] dictionary = in.nextLine().split("[,.;]");
        ArrayDeque<String> deque = new ArrayDeque<>(Arrays.asList(word));
        HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
        StringJoiner ans=new StringJoiner(",");
        while (!deque.isEmpty()){
            String sentence = deque.pollFirst();
            int length = sentence.length();
            while (length>0){
                String substring = sentence.substring(0, length);
                if(set.contains(substring)){
                    ans.add(substring);
                    set.remove(substring);
                    if(length<sentence.length()){
                        deque.offerFirst(sentence.substring(length));
                    }
                    break;
                }
                length--;
            }
            if(length==0){
                ans.add(sentence.substring(0,1));
                if (sentence.length()>1){
                    deque.offerFirst(sentence.substring(1));
                }
            }

        }
        System.out.println(ans);



    }
}

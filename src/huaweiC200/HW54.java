package huaweiC200;

import java.util.*;

public class HW54 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String[] sentences = in.nextLine().split("[,.;]");
            String[] dictionary = in.nextLine().split("[,.;]");
            LinkedList<String> deque=new LinkedList<>(Arrays.asList(sentences));
            HashSet<String> wordSet=new HashSet<>(Arrays.asList(dictionary));
            List<String> answer=new ArrayList<>();
            while (deque.size()>0){
                String sentence = deque.pollFirst();
                int length = sentence.length();
                while (length>0){
                    String substring = sentence.substring(0, length);
                    if(wordSet.contains(substring)){
                        answer.add(substring);
                        wordSet.remove(substring);

                        if(length<sentence.length()){
                            deque.offerFirst(sentence.substring(length));
                        }
//注意
                        break;
                    }
                 length--;
                }
                if(length==0){
                    String substring = sentence.substring(0, 1);
                    answer.add(substring);

                    if(sentence.length()>1){
                        deque.offerLast(sentence.substring(1));
                    }

                }

            }
            StringJoiner joiner = new StringJoiner(",");
            for (String s : answer) {
                joiner.add(s);
            }
            System.out.println(joiner);

        }


    }
}

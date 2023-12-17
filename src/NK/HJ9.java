package NK;

import java.util.*;

public class HJ9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            char[] chars = source.toCharArray();
            for (int i = 0; i < chars.length/2; i++) {
                char temp =chars[i];
                chars[i]=chars[chars.length-i-1];
                chars[chars.length-i-1]=temp;
            }
            LinkedHashSet<Character> characters = new LinkedHashSet<>();
            for (int i = 0; i < chars.length; i++) {
                characters.add(chars[i]);
            }
            StringBuilder stringBuilder=new StringBuilder();
            for (Character temp:characters
                 ) {
                stringBuilder.append(temp);

            }
            System.out.println(stringBuilder);



        }

        }



}

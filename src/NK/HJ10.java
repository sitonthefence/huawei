package NK;

import java.util.HashSet;
import java.util.Scanner;

public class HJ10 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String source = in.next();
            char[] chars = source.toCharArray();
            HashSet<Character> characters = new HashSet<>();
            for (char temp:
                 chars) {
                characters.add(temp);

            }
            System.out.println(characters.size());


        }



    }


}

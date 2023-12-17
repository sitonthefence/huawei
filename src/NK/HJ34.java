package NK;

import java.util.*;

public class HJ34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            List<Character> list=new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                list.add(s.charAt(i));

            }
            Collections.sort(list);
            for (Character temp:
                 list) {
                System.out.print(temp);

            }
            }



        }


    }





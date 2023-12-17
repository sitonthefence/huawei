package LC;

import java.util.ArrayDeque;


public class LC402 {

    public static void main(String[] args) {
        System.out.println(removeKdigits("10", 2));
    }
    public static String removeKdigits(String num,int k){
        ArrayDeque<Character> arrayDeque=new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            while (!arrayDeque.isEmpty()&&k>0&&num.charAt(i)<arrayDeque.peekLast()){
                arrayDeque.pollLast();
                k--;
            }
            arrayDeque.offerLast(num.charAt(i));
        }
        for (int i = 0; i < k; i++) {
            arrayDeque.pollLast();
        }

        if (arrayDeque.isEmpty()){
            return "0";
        }
        while (arrayDeque.peekFirst()=='0'&&arrayDeque.size()!=1){
            arrayDeque.pollFirst();
        }
        StringBuilder stringBuilder=new StringBuilder();
       while (!arrayDeque.isEmpty()) {
            stringBuilder.append(arrayDeque.pollFirst());
        }
        return stringBuilder.toString();

    }


}

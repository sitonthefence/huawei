package LC;

import java.util.ArrayDeque;

public class LC402office {
    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && digit < stack.peekLast()) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean leadZero = true;
        while (!stack.isEmpty()) {
            char digit = stack.pollFirst();
            if (leadZero && digit == '0') {
                continue;
            }
            leadZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

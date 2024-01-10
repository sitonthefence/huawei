package NK;

import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();  // 直接读取整行内容
        int ans = 0;
        int i = 0;

        while (i < input.length()) {
            if (input.charAt(i) == '1') {
                i += 2;
            } else {
                if (i == input.length() - 1 || input.charAt(i + 1) == '0') {
                    ans += 1;
                    i += 2;
                } else {
                    i += 3;
                }
            }
        }
        System.out.println(ans);
    }
}


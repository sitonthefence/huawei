package huaweiC100;

import java.util.Scanner;

public class HW56 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int K = in.nextInt();
            String source = in.next();
            String[] split = source.split("-");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(split[0] + "-");
            for (int i = 1; i < split.length; i++) {
                if (split[i].length() % K == 0) {
                    for (int j = 0; j < split[i].length() / K; j++) {
                        stringBuilder.append(getString(split[i].substring(j * K, (j + 1) * K)));
                    }
                } else {
                    for (int j = 0; j < split[i].length() / K; j++) {
                        stringBuilder.append(getString(split[i].substring(j * K, (j + 1) * K)));
                    }

                    stringBuilder.append(getString(split[i].substring(split[i].length() / K * K)));
                }
            }
            String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
            System.out.println(substring);
        }
    }

    public static String getString(String str) {
        int countLowerCase = 0;
        int countUpperCase = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                countLowerCase++;
            }
            if (Character.isUpperCase(str.charAt(i))) {
                countUpperCase++;
            }

        }
        if (countLowerCase > countUpperCase) {
            return str.toLowerCase() + "-";
        }
        if (countUpperCase > countLowerCase) {
            return str.toUpperCase() + "-";
        }
        return str+"-";
    }
}

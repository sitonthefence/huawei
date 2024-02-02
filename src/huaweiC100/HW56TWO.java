package huaweiC100;


import java.util.Scanner;
import java.util.StringJoiner;

public class HW56TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int K = in.nextInt();
            String source = in.next();
            String[] split = source.split("-");
            StringJoiner result=new StringJoiner("-");
            result.add(split[0]);
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 1; i < split.length; i++) {
                stringBuilder.append(split[i]);
            }
            for (int i = 0; i < stringBuilder.length()/K; i++) {
                result.add(getString(stringBuilder.substring(i*K,K*(i+1))));
            }
            if(stringBuilder.length()%K!=0){
                result.add(getString(stringBuilder.substring( stringBuilder.length()/K*K)));
            }
            System.out.println(result);
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
            return str.toLowerCase();
        }
        if (countUpperCase > countLowerCase) {
            return str.toUpperCase();
        }
        return str;
    }
}

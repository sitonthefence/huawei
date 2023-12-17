package NK;

import java.util.Scanner;

public class HJ21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String source = in.next();
            String s = source.replaceAll("[abc]", "2").replaceAll("[def]", "3")
                    .replaceAll("[ghi]", "4").replaceAll("[jkl]", "5")
                    .replaceAll("[mno]", "6").replaceAll("[pqrs]", "7")
                    .replaceAll("[tuv]", "8").replaceAll("[wxyz]", "9").replace("Z","a");
            for (int i=0;i<s.length();i++){
                if(s.charAt(i)>='A'&&s.charAt(i)<='Y'){
                    char c = (char) (s.charAt(i) + 32+1);
                    String temp = s.replace(s.charAt(i), c);
                    s=temp;

                }

            }
            System.out.println(s);






        }

    }

}

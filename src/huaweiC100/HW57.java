package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW57 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            int K = in.nextInt();
            char[] chars = source.toCharArray();
            Arrays.sort(chars);
           if(K>chars.length){
               System.out.println(source.indexOf(chars[chars.length-1]));
               continue;
           }
            System.out.println(source.indexOf(chars[K-1]));

        }
    }
}

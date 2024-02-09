package huaweiC100;

import java.util.Scanner;

public class HW1THREE {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = in.next();
        String source = in.next();

        int lastIndex=-1;
        int i=0;
        int j=0;
        while (i<target.length()&&j<source.length()){

            if(target.charAt(i)==source.charAt(j)){
                lastIndex=j;
                i++;

            }
            j++;


        }


        System.out.println(lastIndex);


    }
}

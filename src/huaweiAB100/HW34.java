package huaweiAB100;

import java.util.*;

public class HW34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String source = in.nextLine();
            char[] chars = source.toCharArray();

            for (int i = 0; i < chars.length-1; i++) {
                char minChar='\uffff';
                for (int j = i+1; j <  chars.length; j++) {
                    minChar=chars[i]>chars[j]?chars[j]:minChar;
                }
                int minIndex=-1;
                if(chars[i]>minChar){
                    for (int j = i+1; j < chars.length; j++) {
                        if(chars[j]==minChar){
                            minIndex=j;
                        }
                    }
                }
                if(minIndex!=-1){
                    char tem=chars[i];
                    chars[i]=chars[minIndex];
                    chars[minIndex]=tem;
                    break;
                }

            }
            for (char aChar : chars) {
                System.out.print(aChar);
            }






        }
    }
}
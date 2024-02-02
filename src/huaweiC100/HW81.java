package huaweiC100;

import java.util.Scanner;

public class HW81 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String[] words=new String[length];
        for (int i = 0; i < length; i++) {
            words[i]=in.next();
        }
        String dictionary = in.next();
        int count=0;
        int[] dictionaryCount = getCount(dictionary);
        for (int i = 0; i < length; i++) {
            int dif=0;
            int[] wordCount = getCount(words[i]);
            for (int j = 0; j <128 ; j++) {
                dif+=Math.max(wordCount[j]-dictionaryCount[j],0);
            }
            if(dif<=dictionaryCount['?']){
                count++;
            }
        }
        System.out.println(count);


    }
    public static int[] getCount(String str){
        int[] count = new int[128];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        return count;


    }

}

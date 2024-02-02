package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW11TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String str = source.toLowerCase();
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                    stringBuilder.append(str.charAt(i));
                }
            }
           str=stringBuilder.toString();

            List<Letter> result=new ArrayList<>();
            int[] count=new int[128];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i)]++;
            }
            char pre = str.charAt(0);
            int total=1;
            count[pre]--;
            str=str+" ";
            for (int i =1 ; i <str.length() ; i++) {
               char  curChar=str.charAt(i);
                count[curChar]--;
                if(curChar==pre){
                    total++;
                    //坑，不能写
           //         count[curChar]--;

                }else {
                    if(total==1){
                        result.add( new Letter(str.charAt(i-1),count[str.charAt(i-1)]));
                    }else {
                        result.add( new Letter(str.charAt(i-1),total));
                        total=1;
                    }
                    pre=curChar;

                }
            }

            result.sort((o1,o2)->{
                {
                    if(o1.num==o2.num){
                        return   o1.letter-o2.letter;
                    }else {
                        return o2.num-o1.num;
                    }
                }
            });
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i).letter);
                System.out.print(result.get(i).num);
            }

        }
    }
    static class Letter{
        char letter;
        int num;

        public Letter(char letter, int num) {
            this.letter = letter;
            this.num = num;
        }
    }
}

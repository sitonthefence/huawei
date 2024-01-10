package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String str = source.toLowerCase();
            List<Letter> result=new ArrayList<>();
             int[] chars=new int[128];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i)]++;
            }
            str = str + " ";
            char currentChar=str.charAt(0);
            int count=1;
            chars[currentChar]--;
            for (int i = 1; i <str.length() ; i++) {
                chars[str.charAt(i)]--;
                if(str.charAt(i)==currentChar){
                    count++;
                }else {
                        Letter letter = new Letter();
                        letter.letter=currentChar;
                        if(count==1){
                            letter.num=chars[currentChar];
                        }else {
                            letter.num=count;
                        }
                        result.add(letter);
                 currentChar=str.charAt(i);
                    count=1;
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
}
class Letter{
    char letter;
    int num;
}
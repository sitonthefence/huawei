package LC;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC524通过删除字母匹配道的字典最长单词 {
    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));

    }
    public static String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary,
                (a,b)->{
                if(a.length()==b.length()){
                    return a.compareTo(b);
                }else {
                    return b.length()-a.length();
                }
                });
        for (String dic : dictionary) {
            int i=0;
            int j=0;
            while (i<dic.length()&&j<s.length()){
                if(dic.charAt(i)==s.charAt(j)){
                    i++;
                }
                j++;
                if(i==dic.length()){
                    return dic;
                }

            }

        }
        return "";






    }
}

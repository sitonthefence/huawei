package LC;

import java.util.ArrayList;
import java.util.List;

public class LC17电话号码的字母组合 {

    static List<String> result =new ArrayList<>();
    static StringBuilder stringBuilder=new StringBuilder();
    static String[] numString={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        letterCombinations("254");
        System.out.println(result);
    }
    public static List<String> letterCombinations(String digits) {
       if(digits==null||digits.length()==0){
           return result;
       }
        backtracking(digits,0);
       return result;
    }

    public static void backtracking(String digits,int index){
        if(index==digits.length()){
            result.add(stringBuilder.toString());
            return;
        }
        String str=numString[digits.charAt(index)-'0'];
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            backtracking(digits,index+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }



    }



}

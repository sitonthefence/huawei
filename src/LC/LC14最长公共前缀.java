package LC;

import java.util.Arrays;

public class LC14最长公共前缀 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)  return "";
       String result="";
        Arrays.sort(strs);
        for (int i = 1; i <= strs[0].length(); i++) {
            String substring = strs[0].substring(0, i);
            boolean flag=true;
            for (int j = 1; j < strs.length; j++) {
                if(!strs[j].startsWith(substring)){
                    flag=false;
                    break;
                }
            }
            if(flag){
               result=substring;
            }

        }
        return result;


    }
}

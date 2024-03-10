package LC;

import java.util.*;

public class LC49 {
    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            boolean flag=false;
            for (int j = 0; j < result.size(); j++) {
                if(compare(strs[i],result.get(j).get(0))){
                    result.get(j).add(strs[i]);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                List<String> path=new ArrayList<>();
                path.add(strs[i]);
                result.add(path);
            }


        }
        return result;

    }
    public static boolean compare(String a,String b){
        if(a.length()!=b.length()) {
            return false;
        }
        char[] char1 = a.toCharArray();
        char[] char2 = b.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        for (int i = 0; i < char1.length; i++) {
            if(char1[i]!=char2[i]){
                return false;
            }
        }
        return true;



    }
}

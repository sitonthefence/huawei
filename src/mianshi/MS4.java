package mianshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MS4 {
    public static void main(String[] args) {
        for (String s : goodsOrder("agew")) {
            System.out.println(s);
        }


    }
    public static String[] goodsOrder(String goods) {
        List<String> result=new ArrayList<>();
        LinkedList<Character> path=new LinkedList<>();
        char[] chars = goods.toCharArray();
        Arrays.sort(chars);
        boolean[] used=new boolean[chars.length];
        dfs(chars,result,path,used);
        String[] strings = result.toArray(new String[0]);
        return strings;


    }
    public static void dfs(char[] chars,List<String> result,LinkedList<Character> path, boolean[] used){
        if(path.size()==chars.length){
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                stringBuilder.append(path.get(i));
            }
            result.add(stringBuilder.toString());
        }
        for (int i = 0; i < chars.length; i++) {
            if(i>0&&chars[i]==chars[i-1]&&!used[i-1]) continue;
            if(used[i]) continue;
            used[i]=true;
            path.add(chars[i]);
            dfs(chars,result,path,used);
            path.pollLast();
            used[i]=false;
        }

    }

}

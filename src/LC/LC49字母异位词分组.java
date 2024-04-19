package LC;

import java.util.*;

public class LC49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (int i = 0; i <strs.length ; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key=new String(temp);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return  new ArrayList<>(map.values());

    }

}

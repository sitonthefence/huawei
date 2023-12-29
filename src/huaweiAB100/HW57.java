package huaweiAB100;

import java.util.*;

public class HW57 {
    public static List<String> result=new ArrayList<>();
    public static StringBuilder stringBuilder=new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String target = in.next();
            char[] chars = target.toCharArray();
            Arrays.sort(chars);
            String targetSort = new String(chars);
            String source = in.next();
            boolean[]used=new boolean[target.length()];
            backtracking(targetSort, used);
            boolean flag=false;
             int min=Integer.MAX_VALUE;
            for (String s : result) {
                if(source.indexOf(s)!=-1){
                    min=Math.min(min,source.indexOf(s));
                    flag=true;
                }
            }
            if(flag==true){
                System.out.println(min);
            }else {
                System.out.println(-1);
            }
        }
    }
    public static void backtracking(String targetSort, boolean[]used){
        if(stringBuilder.length()==targetSort.length()){
            result.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < targetSort.length(); i++) {
            if(i>0&&targetSort.charAt(i)==targetSort.charAt(i-1)&&!used[i-1]){
                continue;
            }
            if(!used[i]){
                used[i]=true;
                stringBuilder.append(targetSort.charAt(i));
                backtracking(targetSort,used);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                used[i]=false;
            }
        }
    }
}

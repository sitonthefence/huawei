package huaweiC200;

import java.util.*;

public class HW32 {
    static List<LinkedList<Integer>> result;
    static LinkedList<Integer> path;
     static List<Integer> list;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            result=new ArrayList<>();
            path=new LinkedList<>();
            String source = in.next();
            Set<Integer> set=new HashSet<>();
            set.add(source.charAt(0)-'0');
            set.add(source.charAt(1)-'0');
            set.add(source.charAt(3)-'0');
            set.add(source.charAt(4)-'0');
              list=new ArrayList<>(set);
              dfs(0);
            System.out.println(result);






        }
    }
    public static void dfs(int index){
        if(index==list.size()){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            path.add(list.get(i));
            dfs(index+1);
            path.pollLast();
        }
    }



    public static int getTimeNumber(String time){


    }
    public static boolean isValid(String time){

    }
}

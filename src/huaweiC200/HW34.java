package huaweiC200;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class HW34 {
    static String source;
    static HashSet<String> set;
    static LinkedList<Character> path;
    static  int target;
    static boolean[] used;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            source = in.next();
           target= in.nextInt();
        set=new HashSet<>();
        path=new LinkedList<>();
        used=new boolean[source.length()];
        if(source.length()<target||!source.matches("[a-z]+")){
            System.out.println(0);
            return;
        }



        //这个相当于全排列,全排列dfs可以没有参数的
               dfs();
        System.out.println(set.size());

    }
    public static void dfs(){
        if(path.size()==target){
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < path.size(); j++) {
                stringBuilder.append(path.get(j));
            }
            set.add(stringBuilder.toString());
            return;
        }
        for (int j = 0; j < source.length(); j++) {
            if (path.size() == 0) {
                used[j] = true;
                path.offerLast(source.charAt(j));
                dfs();
                path.pollLast();
                used[j] = false;
            } else if ( source.charAt(j) != path.get(path.size()-1) && !used[j]) {
                used[j] = true;
                path.offerLast(source.charAt(j ));
                dfs();
                path.pollLast();
                used[j] = false;
            }
        }

    }


}

package huaweiC200;

import java.util.*;

public class HW28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            List<String> list=new ArrayList<>();
            boolean used[]=new boolean[length];
            Set<String> result=new TreeSet<>() ;
            LinkedList<String> path=new LinkedList<>();
            for (int i = 0; i <length ; i++) {
                list.add(in.next());
            }
            dfs( list, result,used,path);
            for (String s : result) {
                System.out.println(s);
            }

        }
    }
    public static void dfs( List<String> list, Set<String> result,boolean used[],LinkedList<String> path){
        if(path.size()==list.size()){
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                stringBuilder.append(path.get(i));
            }
            result.add(stringBuilder.toString());
        }
        for (int i = 0; i <list.size() ; i++) {
            if(used[i]){
                continue;
            }
            path.offerLast(list.get(i));
            used[i]=true;
            dfs(list,result,used,path);
            path.pollLast();
            used[i]=false;

        }



    }
}

package huaweiAB200;


import java.util.*;

public class HW57 {
   static List<String> result=new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();

            Map<String, List<String>> tree=new HashMap<>();
            for (int i = 0; i < n; i++) {
                String child = in.next();
                String parent = in.next();
                if(tree.containsKey(parent)){
                    List<String> temp = tree.get(parent);
                    temp.add(child);
                }else {
                    List<String> temp=new ArrayList<>();
                    temp.add(child);
                    tree.put(parent,temp);
                }
            }
            String target = in.next();
            dfs( tree,target);
            Collections.sort(result);
            for (String s : result) {
                if(s.equals(target)){
                    continue;
                }
                System.out.println(s);
            }
        }
    }
    public static void dfs( Map<String, List<String>> tree,String target){
        result.add(target);
        if(!tree.containsKey(target)){
            return;
        }
        for (String s : tree.get(target)) {
            dfs(tree,s);
        }

    }

}

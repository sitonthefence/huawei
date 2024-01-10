package huaweiC200;

import java.util.*;

public class HW48 {
    static List<List<Integer>> result=new ArrayList<>();
    static LinkedList<Integer> path=new LinkedList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str1 = in.nextLine();
            String[] split1 = str1.split(" ");
            List<Integer> arr1=new ArrayList<>();
            for (int i = 0; i < split1.length; i++) {
                arr1.add(Integer.valueOf(split1[i]));
            }
            String str2 = in.nextLine();
            String[] split2 = str2.split(" ");
            List<Integer> arr2=new ArrayList<>();
            for (int i = 0; i < split2.length; i++) {
                arr2.add(Integer.valueOf(split2[i]));
            }
            boolean[] used=new boolean[arr1.size()];
           dfs(arr1,used);
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < result.size(); i++) {
                map.put(compare(result.get(i),arr2),map.getOrDefault(compare(result.get(i),arr2),0)+1);
            }
            if(map.containsKey(0)&&map.size()==1){
                System.out.println(0);
            }else {
                LinkedList<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
                Collections.sort(entries,(o1,o2)->o2.getKey()-o1.getKey());
                System.out.println(entries.get(0).getValue());
            }





        }
    }
    public static void  dfs(  List<Integer> arr1,boolean[] used){
            if(path.size()==arr1.size()){
                result.add(new LinkedList<>(new LinkedList<>(path)));
                return;
            }
            for (int i = 0; i < arr1.size(); i++) {
                if(used[i]){
                    continue;
                }
                path.offerLast(arr1.get(i));
                used[i]=true;
                dfs(arr1,used);
                path.pollLast();
                used[i]=false;

            }

    }
    public static int compare( List<Integer> arr1,List<Integer> arr2){
        int count=0;
        for (int i = 0; i <arr1.size(); i++) {
            if(arr1.get(i)>arr2.get(i)){
                count++;
            }
        }
        return count;
    }
}

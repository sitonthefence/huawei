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
           LinkedList<Integer> sourcePath=new LinkedList<>();
                sourcePath.add(source.charAt(0)-'0');
                sourcePath.add(source.charAt(1)-'0');
                sourcePath.add(source.charAt(3)-'0');
                sourcePath.add(source.charAt(4)-'0');
            Set<Integer> set=new HashSet<>();
            set.add(source.charAt(0)-'0');
            set.add(source.charAt(1)-'0');
            set.add(source.charAt(3)-'0');
            set.add(source.charAt(4)-'0');
              list=new ArrayList<>(set);
              dfs(0);
          int index=-1;
            for (int i = 0; i < result.size(); i++) {
               if(getTimeNumber(sourcePath)==getTimeNumber(result.get(i))){
                   index=i;
                }
            }
            if(index==result.size()-1){
                index=0;
            }
            else {
                index++;
            }
            System.out.println(result.get(index).get(0)+""+ result.get(index).get(1)+
                    ":"+ result.get(index).get(2)+result.get(index).get(3));
        }
    }
    public static void dfs(int index){
        if(index==4){
            if(isValid(path)){
                result.add(new LinkedList<>(path));
            }
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            path.add(list.get(i));
            dfs(index+1);
            path.pollLast();
        }
    }
  public static int getTimeNumber(LinkedList<Integer> path){
           return (path.get(0)*10+path.get(1))*60+(path.get(2)*10+path.get(3));
    }
    public static boolean isValid(LinkedList<Integer> path){
         int h=path.get(0)*10+path.get(1);
         int s=path.get(2)*10+path.get(3);
         return h>=0&&h<=23&&s>=0&&s<=59;
    }
}

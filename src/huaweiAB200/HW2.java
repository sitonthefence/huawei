package huaweiAB200;

import java.util.*;

public class HW2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            List<LinkedList<Integer>> result=new ArrayList<>();
            LinkedList<Integer> path=new LinkedList<>();
            String source = in.next();
            String[] split = source.split(",");
            int[] nums=new int[split.length];
            for (int i = 0; i < split.length; i++) {
                nums[i]=Integer.valueOf(split[i]);
            }
            Arrays.sort(nums);
            int length=in.nextInt();
            backtracking(length,nums,0,result,path);
            for (int i = 0; i < result.size(); i++) {
                StringBuilder stringBuilder=new StringBuilder();
                for (int j = 0; j < result.get(i).size(); j++) {
                    stringBuilder.append(result.get(i).get(j)).append(",");
                }
                String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
                System.out.println(substring);
            }
        }
    }
    public static void backtracking(int length,int[]nums,int begin,List<LinkedList<Integer>> result,LinkedList<Integer> path){
        if(path.size()>=length){
            result.add(new LinkedList<>(path));
        }
        for (int i = begin; i <nums.length ; i++) {
           path.offerLast(nums[i]);
           backtracking(length,nums,i+1,result,path);
            path.pollLast();
        }
    }
}

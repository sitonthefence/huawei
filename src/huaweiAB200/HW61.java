package huaweiAB200;

import java.util.*;

public class HW61 {
    public static void main(String[] args) {
        List<LinkedList<Integer>> result=new ArrayList<>();
        LinkedList<Integer> path=new LinkedList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[] nums=new int[length];
             int total=0;
            for (int i = 0; i < nums.length; i++) {
                nums[i]=in.nextInt();
                total=total+nums[i];
            }
            if(total%2==1){
                System.out.println(-1);
                break;
            }
            int target=total/2;
            Arrays.sort(nums);
            dfs(nums,target,0,0,result, path);
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < result.size(); i++) {
                min=Math.min(min,result.get(i).size());
            }
            System.out.println(min);
        }
    }
    public static void dfs(int[] nums,int target,int sum,int begin,List<LinkedList<Integer>> result, LinkedList<Integer> path){
         if(sum>target||path.size()==nums.length){
             return;
         }
         if(sum==target){
             result.add(new LinkedList<>(path));
         }
        for (int i = begin; i < nums.length; i++) {
            path.offerLast(nums[i]);
            sum+=nums[i];
            dfs(nums,target,sum,i+1,result,path);
            path.pollLast();
            sum-=nums[i];

        }
         
         

        
    }
}

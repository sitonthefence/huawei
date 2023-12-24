package huawei200;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HW25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int[] nums=new int[10];
            int total=0;
            for (int i = 0; i < 10; i++) {
                nums[i]=in.nextInt();
                total=total+nums[i];
            }

            LinkedList<Integer> path=new LinkedList<>();
            List<Integer> minResult=new LinkedList<>();
            minResult.add(Integer.MAX_VALUE);
            backtracking(nums,0,minResult,path,0,total);
            System.out.println(minResult.get(0));
        }
    }
    public static  void backtracking(int[] nums,int begin, List<Integer> minResult,LinkedList<Integer> path,int sum,int total){
      if(path.size()==5){
         if(Math.abs(total-2*sum)<minResult.get(0)){
             minResult.remove(0);
                   minResult.add(Math.abs(total-2*sum));

         }
          return;
      }
        for (int i = begin; i <nums.length ; i++) {
            path.offerLast(nums[i]);
            sum+=nums[i];
            backtracking(nums,i+1,minResult,path,sum,total);
            path.pollLast();
            sum-=nums[i];

        }





    }
}

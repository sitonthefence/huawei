package huaweiAB200;

import java.util.*;

public class HW63 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int K = in.nextInt();
        int[] nums=new int[N];
        for (int i = 0; i < N; i++) {
            nums[i]=in.nextInt();
        }
        Arrays.sort(nums);
        List<LinkedList<Integer>> result=new LinkedList<>();
        LinkedList<Integer> path=new LinkedList<>();
        dfs(result,path,0,nums);
       List<Integer> top=new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            top.add(getSum(result.get(i)));
        }
        Collections.sort(top);
        for (int i = 0; i < K; i++) {
            System.out.println(top.get(i));
        }

    }
    public static void dfs( List<LinkedList<Integer>> result,LinkedList<Integer> path,int begin,int[] nums){
        if(path.size()!=0){
            result.add(new LinkedList<>(path));
        }

        if(path.size()==nums.length){
            return;
        }
        for (int i = begin; i <nums.length ; i++) {
  
            path.offerLast(nums[i]);
            dfs(result,path,i+1,nums);

            path.pollLast();
        }

    }
    public static int getSum(LinkedList<Integer> list){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum=sum+list.get(i);
            
        }
        return sum;
        
    }


}

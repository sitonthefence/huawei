package huaweiC100;

import java.util.*;

public class HW34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int N = in.nextInt();
            int[] arr=new int[N];
            Map<Integer, List<Integer>> map=new HashMap<>();
            for (int i = 0; i < N; i++) {
                arr[i]=in.nextInt();
                List<Integer> list=new ArrayList<>();
                map.put(i,list);
            }
            for (int i = 0; i < N-1; i++) {
                map.get(in.nextInt()-1).add(in.nextInt()-1);
            }
            int max=Integer.MIN_VALUE;

            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                int total=arr[entry.getKey()]+ getListSum(entry.getValue(),arr);
                max=Math.max(max,total);
            }
            System.out.println(max);

        }
    }
    public static  int getListSum(List<Integer> list, int[] arr){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            sum+=arr[list.get(i)];
        }
  return sum;

    }
}

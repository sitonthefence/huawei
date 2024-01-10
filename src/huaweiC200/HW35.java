package huaweiC200;

import java.util.*;

public class HW35 {
    static Map<Integer, List<Integer>>  map=new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] dp=new int[length+1];
        for (int i = 1; i <=length ; i++) {
          dp[i]=i;
            List<Integer> list=new ArrayList<>();
            list.add(i);
            map.put(i,list);
            for (int j = 1; j <i ; j++) {
                int profit=dp[j]*dp[i-j];
                 if(profit>dp[i]){
                     dp[i]=profit;
                     List<Integer> list1=new ArrayList<>();
                     list1.addAll(map.get(j));
                     list1.addAll(map.get(i-j));
                     map.put(i,list1);

                 }else if(profit==dp[i]){
                    if((map.get(j).size()+map.get(i-j).size())<map.get(i).size()){
                        List<Integer> list1=new ArrayList<>();
                        list1.addAll(map.get(j));
                        list1.addAll(map.get(i-j));
                        map.put(i,list1);
                    }
                 }
            }
        }
        List<Integer> list = map.get(length);
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }



    }
}

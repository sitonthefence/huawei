package huaweiC200;

import java.util.*;

public class HW35TWO {
    static Map<Integer, List<Integer>> result=new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] profit=new int[length+1];
        for (int i = 1; i <=length ; i++) {
            profit[i]=i;
            List<Integer> path=new ArrayList<>();
            path.add(i);
            result.put(i,path);
            for (int j = 1; j <i ; j++) {
                int temp=profit[i-j]*profit[j];
                if(temp>profit[i]){
                    profit[i]=temp;
                    List<Integer> list=new ArrayList<>();
                   list.addAll(result.get(i-j));
                   list.addAll(result.get(j));
                   result.put(i,list);

                }else if(temp==profit[i]){
                    if(result.get(j).size()+result.get(i-j).size()<result.get(i).size()){
                        List<Integer> list=new ArrayList<>();
                        list.addAll(result.get(i-j));
                        list.addAll(result.get(j));
                        result.put(i,list);
                    }
                }
            }

        }


        List<Integer> list = result.get(length);
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }



    }
}

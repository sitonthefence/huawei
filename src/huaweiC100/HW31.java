package huaweiC100;

import java.util.*;


public class HW31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int target = in.nextInt();
            int []arr=new int[target];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=i+1;
            }
            List<List<Integer>> list=new ArrayList<>();
            int left=0;
            int right=0;
            int currentSum=0;
            while (right<arr.length){
                currentSum+=arr[right];
                while (currentSum>=target){
                    if(currentSum==target) {
                        List<Integer> path=new ArrayList<>();
                        for (int i = arr[left]; i <=arr[right] ; i++) {
                            path.add(arr[i-1]);
                        }
                        list.add(path);
                    }
                    currentSum=currentSum-arr[left];
                    left++;
                }
                right++;
            }

            Collections.sort(list,(o1, o2) ->o1.size()-o2.size() );

            for (int i = 0; i < list.size(); i++) {
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(target+"=");
                for (int j = 0; j < list.get(i).size(); j++) {
                    stringBuilder.append(list.get(i).get(j)+"+");
                }
                String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
                System.out.println(substring);
            }
            System.out.println("Result:"+list.size());

        }



    }
}

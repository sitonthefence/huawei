package huaweiC100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW47TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.next();
        int target = in.nextInt();
        String substring = source.substring(1, source.length() - 1);
        String[] split = substring.split(",");
        int arr[]=new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i]=Integer.valueOf(split[i]);
        }
        StringBuilder stringBuilder=new StringBuilder();
        Map<Integer,Integer> map=new HashMap<>();
        int indexSum=Integer.MAX_VALUE;
        int a=-1;
        int b=-1;
        int minIndex=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {

            if(map.containsKey(target-arr[i])){
                indexSum=i+map.get(target-arr[i]);
                if (indexSum<minIndex){
                    minIndex=indexSum;
                    a=target-arr[i];
                    b=arr[i];
                }
            }else {
                map.putIfAbsent(arr[i],i);
            }



        }
        System.out.print("[");
        System.out.print(a+",");
        System.out.print(b+"]");
    }
}
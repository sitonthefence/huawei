package huaweiC100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW76TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int[] arr=new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i]=Integer.parseInt(split[i]);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i]+1,map.getOrDefault(arr[i]+1,0)+1);
        }
        int count=0;
        for (Map.Entry<Integer, Integer> record : map.entrySet()) {
            if(record.getValue()%record.getKey()==0){
                count+=record.getValue();
            }else {
                count+=(record.getValue()/record.getKey()+1)*record.getKey();

            }


        }
        System.out.println(count);
        
        

    }




}

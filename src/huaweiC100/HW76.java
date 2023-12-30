package huaweiC100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW76 {
    //喊4的有四个人，需要五个人一组
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < split.length; i++) {
                map.put(Integer.valueOf(split[i])+1,map.getOrDefault(Integer.valueOf(split[i])+1,0)+1);
            }
            int sum=0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getKey()>=entry.getValue()){
                    sum=entry.getKey()+sum;
                }else {
                    if(entry.getValue()%entry.getKey()==0){
                        sum= entry.getValue()/entry.getKey()*entry.getKey()+sum;
                    }else {
                        sum= (entry.getValue()/entry.getKey()+1)*entry.getKey()+sum;
                    }
                }
            }
            System.out.println(sum);

        }
    }
}

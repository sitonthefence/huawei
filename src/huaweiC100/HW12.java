package huaweiC100;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HW12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            if(source.equals("@")){
                System.out.println("@");
            }
                String[] split = source.split("@");

                if(split.length==1){
                    System.out.println(split[0]);
                continue;
            }
                if(split[0].equals(split[1])){
                    System.out.println("@");
                }
            Map<String,Integer> map=new LinkedHashMap<>();
            String[] split1 = split[0].split(",");
            for (int i = 0; i < split1.length; i++) {
                String[] split2 = split1[i].split(":");
                map.put(split2[0],Integer.valueOf(split2[1]));
            }
            String[] split3 = split[1].split(",");
            for (int i = 0; i < split3.length; i++) {
                String[] split4 = split3[i].split(":");
                map.put(split4[0],map.get(split4[0])-Integer.valueOf(split4[1]));
            }
            StringBuilder stringBuilder=new StringBuilder();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue()!=0){
                    stringBuilder.append(entry.getKey()+":");
                   stringBuilder.append(entry.getValue()+",");
                }
            }
        if(stringBuilder.length()>0){
            String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
            System.out.println(substring);
        }
        }
    }
}

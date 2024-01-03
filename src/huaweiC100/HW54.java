package huaweiC100;

import java.util.*;

public class HW54 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            Map<Integer,List<String>> map=new HashMap<>();
            for (int i = 1; i <=10 ; i++) {
                List<String> list=new ArrayList<>();
                map.put(i,list);
            }
            for (int i = 0; i < length; i++) {
                String[] split = in.next().split("/");
                for (int j = 0; j < split.length; j++) {
                    if(!split[j].equals("")){
                        map.get(j).add(split[j]);
                    }
                }
            }
            int targetNum = in.nextInt();
            String targetString = in.next();
            List<String> list = map.get(targetNum);
            int count=0;
            for (int i = 0; i < list.size(); i++) {
                   if(targetString.equals(list.get(i))) {
                       count++;

                   }

            }
            System.out.println(count);


        }

    }
}

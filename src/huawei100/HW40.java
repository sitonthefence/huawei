package huawei100;

import java.util.*;

public class HW40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            List<int[]> list =new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                   int[] arr={i,Integer.valueOf(split[i])};
                   list.add(arr);
            }
            list.sort(((o1, o2) -> o2[1]-o1[1]));
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                  if(i==list.get(j)[0]){
                    stringBuilder.append(j).append(",");
                      break;
                  }
                }
            }
            String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
            System.out.println(substring);
        }
    }
}

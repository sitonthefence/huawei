package huaweiAB100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class HW28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
           int vlanNeed= in.nextInt();
            String[] split = source.split(",");
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                if(split[i].matches("[0-9]+")){
                    list.add(Integer.valueOf(split[i]));
                }else {
                    String[] startAndEnd = split[i].split("-");
                    for (int j =Integer.valueOf(startAndEnd[0]) ; j <= Integer.valueOf(startAndEnd[1]); j++) {
                        list.add(j);
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i)==vlanNeed){
                    list.remove(i);
                }
            }
            Collections.sort(list);
            StringBuilder stringBuilder=new StringBuilder();
            int left=list.get(0);
            int right=left;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i)-right>1){
                    print(left,right,stringBuilder);
                    left=list.get(i);
                    right=left;
                }else {
                    right++;
                }
            }
            print(left,right,stringBuilder);
            String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
            System.out.println(substring);
    }
    }
    public  static void print (int left,int right,StringBuilder stringBuilder){
        if(left==right){
            stringBuilder.append(right).append(",");
        }else {
          stringBuilder.append(left).append("-").append(right).append(",");
        }
    }
}

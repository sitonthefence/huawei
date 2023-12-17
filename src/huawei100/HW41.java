package huawei100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                list.add(Integer.valueOf(split[i]));
            }
            System.out.println(getMaxScore(split.length-1,list));
        }
    }
    public static int getMaxScore(int index,List<Integer> list){
        if(index==-2||index==-1||index==-3) {
            return 0;
        }
        return Math.max(getMaxScore(index-3,list),getMaxScore(index-1,list)+list.get(index));
    }

}

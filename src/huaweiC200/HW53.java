package huaweiC200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HW53 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int windowNum=Integer.valueOf(in.nextLine());
        int EveryWindowSize= Integer.valueOf(in.nextLine());
        List<LinkedList<Integer>> list=new ArrayList<>();
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            LinkedList<Integer> path=new LinkedList<>();
            for (int i = 0; i < split.length; i++) {
                path.add(Integer.valueOf(split[i]));
            }
            list.add(path);

        }
        int totalWindowSize=windowNum*EveryWindowSize;
         int [] result=new int[totalWindowSize];
        int index=0;
        int level=0;

        while (index<totalWindowSize){
            //这个问的不应该
            boolean flag=false;
            for (int i = 0; i < windowNum; i++) {
              result[index++] = list.get(level).pollFirst();
              //list.size()>1不写会报算数异常
              if(list.get(level).size()==0&&list.size()>1){
                  list.remove(list.get(level));
                  level=level%list.size();
                flag=true;

              }
            }
            if(!flag){
                level=(level+1)%list.size();
            }
        }
        for (int i = 0; i < windowNum; i++) {
            for (int j = 0; j < EveryWindowSize; j++) {
                System.out.print(result[windowNum*j+i]+" ");
            }
        }

    }
}

package huaweiC200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HW53TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int column = Integer.parseInt(in.nextLine());
        int row = Integer.parseInt(in.nextLine());
        List<LinkedList<Integer>> list = new ArrayList<>();
        while (in.hasNextLine()) {
            String source = in.nextLine();
            String[] split = source.split(" ");
            LinkedList<Integer> path = new LinkedList<>();
            for (int i = 0; i < split.length; i++) {
                path.add(Integer.valueOf(split[i]));
            }
            list.add(path);
        }
        int capacity=row*column;
        int[] result=new int[capacity];
        int index=0;
        int level=0;
        while (index<capacity){
            boolean flag=false;
            for (int i = 0; i <column ; i++) {
                result[index++]=list.get(level).pollFirst();
                if(list.get(level).size()==0&&list.size()>1){
                    list.remove(level);
                    level=level%list.size();
                    flag=true;
                }
            }
            if(!flag){
                level=(level+1)%list.size();
            }
        }
        for (int i = 0; i <column ; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(result[column*j+i]+" ");
            }
        }






    }
}
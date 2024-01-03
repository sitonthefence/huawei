package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW71 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            List<List<Integer>> list=new ArrayList<>();
            for (int i = 0; i < split.length/2; i++) {
                List<Integer> path=new ArrayList<>();
                 path.add(Integer.valueOf(split[2*i]));
                 path.add(Integer.valueOf(split[2*i+1]));
                 list.add(path);
            }
            if(list.size()==2){
                System.out.println(source);
                continue;
            }
            int index=2;
            while (index<list.size()){
                if((list.get(index).get(1)-list.get(index-1).get(1))*(list.get(index-1).get(0)-list.get(index-2).get(0))
                        ==(list.get(index-1).get(1)-list.get(index-2).get(1))*(list.get(index).get(0)-list.get(index-1).get(0))){
                    list.remove(index-1);
                }else {
                    index++;
                }
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(j).size(); j++) {
                    System.out.print(list.get(i).get(j)+" ");
                }
            }

        }

    }
}

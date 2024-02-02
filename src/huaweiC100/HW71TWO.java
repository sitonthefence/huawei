package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW71TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            List<int[]> list=new ArrayList<>();
            for (int i = 0; i < split.length/2; i++) {
                 list.add(new int[]{Integer.valueOf(split[2*i]),Integer.valueOf(split[2*i+1])});
            }
            if(list.size()==2){
                System.out.println(source);
                continue;
            }
            int index=2;
            while (index<list.size()){
                 if((list.get(index-1)[1]-list.get(index-2)[1])*(list.get(index)[0]-list.get(index-1)[0])==
                         (list.get(index)[1]-list.get(index-1)[1])*(list.get(index-1)[0]-list.get(index-2)[0])
                 ){
                        list.remove(index-1);
                 }else {
                     index++;
                 }

            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)[0]+" ");
                System.out.print(list.get(i)[1]+" ");
            }

        }

    }
}

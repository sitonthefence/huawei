package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class HW45 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){

            String[] split = in.nextLine().split("\\W+");
            TreeSet<String> set=new TreeSet<>();
            for (int i = 0; i < split.length; i++) {
                set.add(split[i]);
            }
            String target = in.nextLine();
            List<String> result=new ArrayList<>();
            for (String s : set) {
                if(s.startsWith(target)){
                    result.add(s);
                }
            }
            if(result.size()==0){
                System.out.println(target);
            }else {
                for (String s : result) {
                    System.out.print(s+" ");
                }

            }


        }


    }
}

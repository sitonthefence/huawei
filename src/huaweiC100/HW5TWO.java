package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW5TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        String source = in.next();
        int max=-1;
        int left=0;
        int right=0;
        if(source.matches("[0-9]+")||source.matches("[a-zA-Z]")){
            System.out.println(-1);
            return;
        }

        while (right<source.length()){
            Character c = source.charAt(right);
            if(Character.isLetter(c)){
                list.add(right);
               if(list.size()==2){
                   //易错 不能分步
                   left=list.remove(0)+1;
               }
//               if(left==right){
//                   right++;
//                   continue;
//               }
            }
            if(right-left>=1){
                max=Math.max(max,right-left+1);
            }


            right++;

        }
        System.out.println(max);


    }
}

package huawei100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW42 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            List<String> list=new ArrayList<>();
            int left=0;
            int right=0;
            while (right<source.length()){
                if(source.charAt(left)=='('){
                  while(source.charAt(right)!=')'){
                      right++;
                  }
                    String substring = source.substring(left+1, right);
                    list.add(substring);
                    left=right+1;
                    right=left;

                }else {
                    left++;
                    right++;
                }
            }
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < list.size(); i++) {
                String[] split = list.get(i).split(",");

                    if(split[0].matches("0[0-9]*")||split[1].matches("0[0-9]*")){
                      continue;
                    }
                Integer x = Integer.valueOf(split[0]);
                Integer y = Integer.valueOf(split[1]);
                  int destination =x*x+y*y;
                max=Math.max(max,destination);
            }
            for (int i = 0; i < list.size(); i++) {
                String[] split = list.get(i).split(",");

                if(split[0].matches("0[0-9]*")||split[1].matches("0[0-9]*")){
                    continue;
                }
                Integer x = Integer.valueOf(split[0]);
                Integer y = Integer.valueOf(split[1]);
                if(x*x+y*y==max){
                    System.out.print("("+x+","+y+")");
                }
            }





        }


    }
}

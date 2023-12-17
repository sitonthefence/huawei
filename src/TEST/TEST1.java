package TEST;
//给定一个长度为n 的整数序列，请找出最长的不包含重复的数的连续区间，输出它的长度。
//5
//1 2 2 3 5
//输出3  (2 3 5)

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TEST1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i <length ; i++) {
                list.add(in.nextInt());
            }
            int left =0;
            int right=0;
            int maxResult=0;
            for (int i = 1; i <length ; i++) {
                if(list.get(i)-list.get(right)==0){
                    maxResult=Math.max(right-left+1,maxResult);
                    left=i;
                  right=left;
                }else {
                    right++;
                }
            }
            if(list.get(length-1)!=list.get(length-2)){
                   maxResult=Math.max(maxResult,right-left+1);
            }



            System.out.println(maxResult);
        }


    }

}

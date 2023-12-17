package huawei100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HW27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            List<String> list=new ArrayList<>();
            for (int i = 0; i < length; i++) {
                list.add(in.next());
            }
         list.sort(((o1, o2) -> getTarget(o1)-getTarget(o2)));
            for (int i = 0; i < length; i++) {
                System.out.println(list.get(i));
            }
        }
    }
    public static int getTarget(String source){
        char[] sourceChars = source.toCharArray();
        int left =0;
        int right=0;
        char curChar=0;
        int total=0;
        while (right<sourceChars.length){
            curChar=sourceChars[right];
            if (curChar=='M'||curChar=='G'||curChar=='T'){
               if (curChar=='M'){
                   total=Integer.valueOf(source.substring(left,right))+total;
               }else if(curChar=='G'){
                   total=Integer.valueOf(source.substring(left,right))*1024+total;
               }else {
                   total=Integer.valueOf(source.substring(left,right))*1024*1024+total;
               }
                left=right+1;
            }
            right++;
        }
        return total;

        }

    }







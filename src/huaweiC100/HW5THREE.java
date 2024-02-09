package huaweiC100;

import java.util.Scanner;

public class HW5THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.next();
        int left=0;
        int right=0;
        int index=-1;
        int cur=0;
        int max=-1;
        boolean flag=false;
        while (right<source.length()){
            if (Character.isLetter(source.charAt(right))){
                if(flag){
                    left=index+1;
                }else {
                    flag=true;
                }
                index=right;
            }
            if(flag){
                cur=right-left+1;
                if(cur>1){
                    max=Math.max(cur,max);
                }

            }


         right++;
        }
        System.out.println(max);


    }
}

package huaweiC100;

import java.util.Scanner;

public class HW26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            int left=0;
            int right=0;
            int currentX=0;
            int currentY=0;
            int count=0;
            while (right<source.length()){
                if(source.charAt(right)=='X'){
                    currentX++;
                }else {
                    currentY++;
                }
                if(currentX==currentY){
                   count++;
                   left=right+1;
                }
                right++;
            }
            System.out.println(count);

        }


    }
}

package huaweiC100;

import java.util.Scanner;

public class HW14{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            int count=0;
            for (int i = 0; i < source.length(); i++) {
                if(source.charAt(i)=='o'){
                    count++;
                }
            }
            if(count%2==0){
                System.out.println(source.length());
            }else {
                System.out.println(source.length()-1);
            }

        }
    }
}

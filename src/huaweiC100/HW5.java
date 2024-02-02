package huaweiC100;

import java.util.Scanner;
//错误
public class HW5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            if(source.matches("[a-zA-Z]+")||source.matches("[0-9]+")){
                System.out.println(-1);
                continue;
            }
            String[] split = source.split("[a-zA-Z]+");
            int maxNum=Integer.MIN_VALUE;
            for (int i = 0; i < split.length; i++) {
                maxNum=Math.max(maxNum,split[i].length());
            }
            System.out.println(maxNum+1);

        }
    }
}

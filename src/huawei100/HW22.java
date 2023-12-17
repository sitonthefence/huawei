package huawei100;

import java.util.Scanner;

public class HW22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            if(source.matches("[0-9]+")||source.matches("[a-zA-Z]+")){
                System.out.println(-1);
                continue;
            }
            String[] split = source.split("[a-zA-Z]+");
            int max=0;
            for (int i = 0; i < split.length; i++) {
                max=Math.max(max,split[i].length());
            }
            System.out.println(max+1);
        }
    }
}

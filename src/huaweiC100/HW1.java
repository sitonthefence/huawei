package huaweiC100;

import java.util.Scanner;
//错误
public class HW1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            String target = in.next();
            String source = in.next();
            int index=0;
            boolean flag=false;
            int lastIndex=-1;
            if(target.length()>source.length()){
                System.out.println(-1);
                return;
            }
            for (int i = 0; i < target.length(); i++) {
                for (int j = index; j < source.length(); j++) {
                    if(target.charAt(i)==source.charAt(j)){
                        index=j+1;
                        flag=true;
                        lastIndex=j;
                        break;
                    }
                }
                if(!flag){
                    System.out.println(-1);
                    return;

                }
            }
        System.out.println(lastIndex);


    }
}

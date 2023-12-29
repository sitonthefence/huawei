package huaweiAB100;

import java.util.Scanner;

public class HW52 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String target = in.next();
            String source=in.next();
            int index=0;
            for (int i = 0; i < target.length(); i++) {
                boolean flag=false;
                for (int j = index; j <source.length() ; j++) {
                    if(target.charAt(i)==source.charAt(j)){
                        index=j+1;
                        flag=true;
                        if(i==target.length()-1){
                            System.out.println(j);
                        }
                        break;
                    }


                }
                if(flag==false){
                    System.out.println("-1");
                    break;
                }
            }

        }
    }
}

package NK;

import java.util.Scanner;

public class HJ81 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();

        for (int i = 0; i < str1.length(); i++) {
            boolean flag=false;
            for (int j = 0; j< str2.length(); j++) {
                if ( str1.charAt(i)==str2.charAt(j)){
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");


    }



}

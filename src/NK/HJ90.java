package NK;

import java.util.Scanner;

public class HJ90 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String out="YES";

            if(!source.matches("[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+")){
                out="NO";
            }else {
                for (String s : source.split("\\.")) {
                    if(Integer.valueOf(s)>255||Integer.valueOf(s)<0||s.charAt(0)=='0'&&s.length()!=1){
                        out="NO";
                    }
                }
            }
            System.out.println(out);
        }
    }





}

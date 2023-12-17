package huawei100;

import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int source = in.nextInt();
            String s = Integer.toBinaryString(source);
            StringBuilder stringBuilder = new StringBuilder();
            while (s.length()>0){
                String substring = new String();
                if(s.length()>7){
                    substring=s.substring(s.length()-7);
                    s=s.substring(0,s.length()-7);
                    substring='1'+substring;
                }else {
                    for(int i=0;i<7-s.length();i++){
                        substring='0'+substring;
                    }
                    substring='0'+substring+s;
                    s="";
                }
            stringBuilder.append(substring);
            }
            String s1 = stringBuilder.toString();
            for (int i = 0; i < (s1.length()/8); i++) {
                String substring1 = s1.substring(8*i, 8 * (i+1));
                String s2 = Integer.toHexString(Integer.valueOf(substring1, 2));
                if(s2.length()!=2){
                    s2='0'+s2;
                }
                System.out.print(s2.toUpperCase());
            }
        }
    }
}

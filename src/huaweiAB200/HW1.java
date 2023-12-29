package huaweiAB200;

import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
    String[] split = source.split("00");
  //    String[] split = source.split("00");
            int max=Integer.MIN_VALUE;
            String result="";
            for (int i = 0; i < split.length; i++)
            {
                if(split[i].equals("")){
                    continue;
                }
                if(split[i].charAt(0)=='1'){
                    StringBuilder stringBuilder=new StringBuilder();
                    split[i]=stringBuilder.append('0').append(split[i]).toString();
                }
                if(split[i].charAt(split[i].length()-1)=='1'){
                    StringBuilder stringBuilder=new StringBuilder();
                    split[i]=stringBuilder.append(split[i]).append('0').toString();
                }
                if(split[i].length()>max&&split[i].matches("0+(10){2,}0*")){
                    max=split[i].length();
                    result=split[i];
                }

            }
            if (max==Integer.MIN_VALUE){
                System.out.println(-1);
            }else {
                System.out.println(result);
            }

        }


    }
}

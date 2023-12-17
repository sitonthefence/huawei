package NEWHUAWEI;

import java.util.Scanner;

public class ID210 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split(",");
            int count=0;
            for (int i = 0; i < split.length; i++) {
                if(i==0&&split.length>=2&&Integer.valueOf(split[i])>Integer.valueOf(split[i+1])){
                   count++;

                }
                if(i==split.length-1&&split.length>=2&&Integer.valueOf(split[i])>Integer.valueOf(split[i-1])){
                    count++;
                }
                if(i!=0&&i!=split.length-1&&split.length>=3&&Integer.valueOf(split[i])>Integer.
                        valueOf(split[i+1])&&Integer.valueOf(split[i])>Integer.valueOf(split[i-1])){
                    count++;
                }

            }
            System.out.println(count);


        }




    }






}

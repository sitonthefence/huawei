package huawei100;

import java.util.Scanner;

public class HW78 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            String flag="invalid Ip";
            if(!source.matches("[0-9]+#[0-9]+#[0-9]+#[0-9]+")){
                }else {
                String[] split = source.split("#");
                for (int i = 0; i < 4; i++) {
                    if(Integer.valueOf(split[0])<1&&Integer.valueOf(split[0])>128||Integer.valueOf(split[i])<0&&Integer.valueOf(split[i])>255
                            ||split[i].charAt(0)=='0'&&split[i].length()==1){

                    }else {
                        StringBuilder stringBuilder=new StringBuilder();
                        for (int j = 0; j < 4; j++) {

                            Integer integer = Integer.valueOf(Integer.toBinaryString(Integer.valueOf(split[j])));
                            String format = String.format("%08d", integer);
                            stringBuilder.append(format);

                        }
                        String s = String.valueOf(Long.valueOf(stringBuilder.toString(), 2));
                        flag=s;

                    }



                    }

            }
            System.out.println(flag);




        }
    }
}

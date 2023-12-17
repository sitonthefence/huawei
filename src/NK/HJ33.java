package NK;

import java.util.Scanner;

public class HJ33 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            if(source.contains(".")){
                StringBuilder stringBuilder=new StringBuilder();
                String[] split = source.split("\\.");
                for (int i = 0; i < split.length; i++) {
                    Integer integer = Integer.valueOf(split[i]);
                    String s = Integer.toBinaryString(integer);
                    Integer integer1 = Integer.valueOf(s);
                    String format = String.format("%08d", integer1);
                    stringBuilder.append(format);
                }
                String s = stringBuilder.toString();
                Long aLong = Long.valueOf(s,2);
                System.out.println(aLong);
            }else {
                Long integer = Long.valueOf(source);
                String s = Long.toBinaryString(integer);
                String substring1 = s.substring(0, s.length() - 24);
                Integer integer1 = Integer.valueOf(substring1, 2);
                String substring2 = s.substring(s.length() - 24, s.length() - 16);
                Integer integer2 = Integer.valueOf(substring2, 2);
                String substring3 = s.substring(s.length() - 16, s.length() - 8);
                Integer integer3 = Integer.valueOf(substring3, 2);
                String substring4 = s.substring(s.length() - 8);
                Integer integer4 = Integer.valueOf(substring4, 2);
                System.out.println( integer1+"."+integer2+"."+integer3+"."+integer4);


            }


        }




    }

}

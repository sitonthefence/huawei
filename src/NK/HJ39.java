package NK;

import java.util.Scanner;

public class HJ39 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int flag=0;
            String mask = in.nextLine();
            String ip1 = in.nextLine();
            String ip2 = in.nextLine();
            if(!ipIsValid(ip1)||!ipIsValid(ip2)||!maskIsValid(mask)){
                flag=1;
            }else {
                if(isOneNetWork(ip1,ip2,mask)){
                    flag=0;
                }
                else {
                    flag=2;
                }
            }
            System.out.println(flag);
        }
    }

    public static boolean ipIsValid(String source){
      boolean flag=true;
      if(!source.matches("[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+")){

          flag=false;
      }else{
          for (String s : source.split("\\.")) {
              if(Integer.valueOf(s)>255||Integer.valueOf(s)<0||s.charAt(0)=='0'&&s.length()!=1){
                  flag=false;
              }
          }
      }
      return flag;

    }
    public static boolean maskIsValid(String source){
        boolean ipIsValid = ipIsValid(source);
        boolean flag=false;
        StringBuilder stringBuilder=new StringBuilder();
        if(ipIsValid){
            for (String s : source.split("\\.")) {
                Integer integer = Integer.valueOf(Integer.toBinaryString(Integer.valueOf(s)));
                String format = String.format("%08d", integer);
                stringBuilder.append(format);
            }
            String s = stringBuilder.toString();
            if(s.matches("[1]+[0]+")){
                flag=true;
            }
        }
        return  flag;
    }
    public static boolean isOneNetWork(String ip1,String ip2,String mask){

        boolean flag=true;
        String[] split1 = ip1.split("\\.");
        String[] split2 = ip2.split("\\.");
        String[] split3 = mask.split("\\.");
        for (int i = 0; i < 4; i++) {
            int i1 = Integer.valueOf(split1[i]) & Integer.valueOf(split3[i]);
            int i2 = Integer.valueOf(split2[i]) & Integer.valueOf(split3[i]);
            if(i1!=i2){
                flag=false;
                break;
            }
        }
        return flag;

    }






}

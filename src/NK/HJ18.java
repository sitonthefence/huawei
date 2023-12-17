package NK;

import java.util.Scanner;

public class HJ18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int AIpCount=0;
        int BIpCount=0;
        int CIpCount=0;
        int DIpCount=0;
        int EIpCount=0;
        int ErrorIpCount=0;
        int privateIpCount=0;
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split("~");
            String ip=split[0];
            String mask=split[1];
            if(ipIsValid(ip)&&maskIsValid(mask)){
                String[] split1 = ip.split("\\.");
                if (Integer.valueOf(split1[0])>=1&&Integer.valueOf(split1[0])<=126){
                    AIpCount++;
                }else if(Integer.valueOf(split1[0])>=128&&Integer.valueOf(split1[0])<=191){
                    BIpCount++;
                }
                else if(Integer.valueOf(split1[0])>=192&&Integer.valueOf(split1[0])<=223){
                    CIpCount++;
                }
                else if(Integer.valueOf(split1[0])>=224&&Integer.valueOf(split1[0])<=239){
                    DIpCount++;
                }
                else if(Integer.valueOf(split1[0])>=240&&Integer.valueOf(split1[0])<=255){
                    EIpCount++;
                }

            }
            if(!ipIsOthers(ip)){
                if(!ipIsValid(ip)||!maskIsValid(mask)){
                    ErrorIpCount++;
                }
            }
            if(isPrivateIp(ip)&&maskIsValid(mask)){

                privateIpCount++;
            }


        }
        System.out.print(AIpCount+" "+BIpCount+" "+CIpCount+" "+DIpCount+" "+EIpCount+" "+ErrorIpCount+" "+privateIpCount);

    }

    public  static boolean ipIsValid(String ip) {
        boolean flag=true;
        if (!ip.matches("[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+")) {
            flag = false;
        } else {
            for (String s : ip.split("\\.")) {
                if (Integer.valueOf(s) > 255 || Integer.valueOf(s) < 0 || s.charAt(0) == '0' && s.length() != 1) {
                    flag = false;
                }
            }
        }
        return flag;
    }
    public   static boolean isPrivateIp(String ip){
        boolean flag=false;
        if(ipIsValid(ip)){
            String[] split = ip.split("\\.");
            if(Integer.valueOf(split[0])==10
                    ||Integer.valueOf(split[0])==172&&Integer.valueOf(split[1])>=16&&Integer.valueOf(split[1])<=31
                    ||Integer.valueOf(split[0])==192&&Integer.valueOf(split[1])==168
            ){
                flag=true;
            }
        }
        return  flag;

    }
    public  static boolean  maskIsValid(String mask){
        boolean flag=false;
        StringBuilder stringBuilder=new StringBuilder();
        if(ipIsValid(mask)){
            for (String s : mask.split("\\.")) {
                Integer integer = Integer.valueOf(Integer.toBinaryString(Integer.valueOf(s)));
                String format = String.format("%08d", integer);
                stringBuilder.append(format);
            }
            String s = stringBuilder.toString();
             if(s.matches("1+0+")){
                 flag=true;
             }
        }
        return  flag;
    }
    public  static  boolean ipIsOthers(String ip){
        boolean flag=false;
        if(ip.matches("0\\..+\\..+\\..+")||ip.matches("127\\..+\\..+\\..+")){

            flag=true;
        }
        return flag;

    }











}

package huaweiAB200;

import java.util.Scanner;

public class HW62 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            boolean flag=false;
            int split1=0;
            int split2=0;
            loop:
            for (int i = 1; i <source.length()-3 ; i++) {
                for (int j = i+2; j <source.length()-1 ; j++) {
                    int a = getInstance(source.substring(0, i));
                    int b = getInstance(source.substring(i+1, j));
                    int c = getInstance(source.substring(j+1,source.length()));
                    if(a==b&&a==c){
                        split1=i;
                        split2=j;
                       flag=true;
                        break loop;
                    }
                }
            }
            if (flag==true){
                System.out.println(split1+","+split2);
            }else {
                System.out.println("0,0");
            }


        }


    }

    public static  int getInstance(String str){
        int sum=0;
        for (int i = 0; i < str.length(); i++) {
            sum=sum+str.charAt(i);
        }
        return sum;

    }
}

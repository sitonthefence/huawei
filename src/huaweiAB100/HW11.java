package huaweiAB100;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW11 {
    public static List<Integer> list=new ArrayList<>();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
            String source = in.nextLine();
             findData(source,2);
             if(list.size()==0){
                 System.out.println(0);
             }
             else if (list.size()==1){
                 System.out.println(list.get(0));
             }else {
                 System.out.println(-1);
             }
    }

    public static void findData(String source,int number){
        for (int i = 0; i < source.length(); i++) {
            String substring1 = source.substring(0, i + 1);
            String substring2 = source.substring(i + 1);
            if(isWaterNum(substring1)){
                if(isWaterNum(substring2)){
                   list.add(number);
                }else {
                    findData(substring2,number++);
                }
            }
        }

    }
    public  static boolean isWaterNum(String str){
        int num=0;
        for (int i = 0; i < str.length(); i++) {
            num=num+str.charAt(i);
        }
         if (String.valueOf(num).length()!=3){
             return false;
         }
         int a=num/100;
         int b=num%100/10;
         int c=num%10;
         int sum=a*a*a+b*b*b+c*c*c;
         if (num==sum){
             return true;
         }
         return false;
    }
}

package huaweiAB100;

import java.util.Scanner;

public class HW56 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] split = source.split("[a-zA-Z]+");

            int sum=0;
            for (int i = 0; i < split.length; i++) {
                if(!split[i].equals("")){
                    int left=0;
                    int right=0;
                    for (int j = 1; j <split[i].length() ; j++) {
                        if(split[i].charAt(j)!='-'){
                            right++;
                        }else {
                            sum=sum+getMin(left,right,split[i]);
                            left=right+1;
                            right=left;
                        }
                    }
                    sum=sum+getMin(left,right,split[i]);

                }


            }
            System.out.println(sum);
        }

    }
    public static  int getMin(int left,int right,String source){
        //注意先取子串
        String substring = source.substring(left, right + 1);
        if(substring.contains("-")){
            return Integer.valueOf(substring);
        }else {
            int sum=0;
            for (int i = left; i <=right ; i++) {
                sum=sum+Integer.valueOf(source.substring(i,i+1));
            }
            return sum;
        }
    }
}

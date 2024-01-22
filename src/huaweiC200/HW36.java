package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;
public class HW36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int[] N=new int[R+1];
        for (int i = 0; i < N.length; i++) {
            N[i]=in.nextInt();
        }
        int D=in.nextInt();
        String source = new StringBuilder(Integer.toBinaryString(D)).reverse().toString();
        int[] subtrahend=new int[source.length()];
        for (int i = 0; i < subtrahend.length; i++) {
            subtrahend[i]=source.charAt(i)-'0';
        }
        int count=0;
        for (int i = N.length-1; i>=subtrahend.length ; i--) {
            count+=N[i];
        }
        int [] minuend= Arrays.copyOfRange(N,0,subtrahend.length);
        while (binary_sub(minuend,subtrahend)){
            count++;
        }
        System.out.println(count);
    }
    public static boolean binary_sub(int[] minuend,int[] subtrahend){
        //i>=0多弄了一个小时
        for (int i =minuend.length-1; i >=0 ; i--) {
            if(minuend[i]-subtrahend[i]>=0){
                minuend[i]-=subtrahend[i];
            }else {
                if(cal_binary(Arrays.copyOfRange(minuend,0,i+1))
                        -cal_binary(Arrays.copyOfRange(subtrahend,0,i+1))<0){
                     int j=i+1;
                     while (j<minuend.length){
                         if(minuend[j]>0){
                             minuend[j]-=1;
                             return true;
                         }
                         j++;
                     }
                     return false;
                }else {
                    minuend[i]-=subtrahend[i];
                    minuend[i-1]+=minuend[i]<<1;
                    minuend[i]=0;
                }
            }
        }
        return true;
    }

    public static int cal_binary(int[] arr){
        int result=0;
        for (int i = 0; i < arr.length; i++) {
            result+=arr[i]*(1<<i);
        }
        return result;
    }

}

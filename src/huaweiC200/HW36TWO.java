package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW36TWO {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int[] N=new int[R+1];
        for (int i = 0; i < N.length; i++) {
            N[i]=in.nextInt();
        }
        int[] D = Arrays.stream(new StringBuilder(Integer.toBinaryString(in.nextInt())).reverse().toString().split("")).
                mapToInt(Integer::parseInt).toArray();

        int total=0;
        for (int i = N.length-1; i>=D.length ; i--) {
            total+=N[i];
        }
        int[] jianshu = Arrays.copyOfRange(N, 0, D.length);
        while (bin_sub(jianshu,D)){
            total++;
        }
        System.out.println(total);


    }
    public static boolean bin_sub(int[] jianshu,int[] beijianshu){
        for (int i =jianshu.length-1 ; i >=0 ; i--) {
            if(jianshu[i]-beijianshu[i]>=0){
                jianshu[i]-=beijianshu[i];
            }else {
                if(cal_bin(Arrays.copyOfRange(jianshu,0,i+1))-
                        cal_bin(Arrays.copyOfRange(beijianshu,0,i+1))<0){
                    int j=i+1;
                    while (j<jianshu.length){
                        if(jianshu[j]>0){
                            jianshu[j]-=1;
                            return true;
                        }
                        j++;
                    }
                    return false;
                }
                else {
                    jianshu[i]-=beijianshu[i];
                    jianshu[i-1]+=jianshu[i]*2;
                    jianshu[i]=0;

                }

            }

        }
        return true;


    }


    public static int cal_bin(int[] arr){
        int result=0;
        for (int i = 0; i <arr.length ; i++) {
            result+=arr[i]*(1<<i);
        }
        return result;
    }





}

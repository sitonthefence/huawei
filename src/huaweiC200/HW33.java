package huaweiC200;


import java.util.Scanner;

public class HW33 {
    static long x;
    static long y;
    static long cntx;
    static long cnty;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       x = in.nextLong();
       y= in.nextLong();
        cntx =in.nextLong();
        cnty =in.nextLong();
        long left=1;
        long target=1000000000L;
        long right=target;
        while (left<right){
            long middle=(left+right)/2;
            if(check(middle)){
                target=middle;
                right=middle;

            }else {
                left=middle+1;
            }
        }
        System.out.println(target);

    }
    //公式要记住
    public static boolean check(long k){
        long a=  k/x- k/x/y;
        long b=  k/y- k/x/y;
        long c=  k/x/y;
        long d= k-a-b-c;
        return d>=Math.max(0,cnty-a)+Math.max(0,cntx-b);

    }
}

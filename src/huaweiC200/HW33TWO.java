package huaweiC200;

import java.util.Scanner;


public class HW33TWO {
    static long countryXId;
    static long countryYId;
    static long countryXNeed;
    static long countryYNeed;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        countryXId = in.nextLong();
        countryYId=in.nextLong();
        countryXNeed=in.nextLong();
        countryYNeed=in.nextLong();
        long left=countryXNeed+countryYNeed;
        long right=1000000000L;
        long target=right;
        while (left<right){
            long mid=(left+right)/2;
            if(check(mid)){
                right=mid;
                target=mid;

            }else {
                left=mid+1;
            }

        }
        System.out.println(target);


    }
    public static boolean check(long mid){
        long a=mid/countryXId-mid/countryXId/countryYId;
        long b=mid/countryYId-mid/countryXId/countryYId;
        long c=mid/countryXId/countryYId;
        long d=mid-a-b-c;
        return d>=Math.max(0,countryYNeed-a)+Math.max(0,countryXNeed-b);

    }
}

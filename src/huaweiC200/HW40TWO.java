package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW40TWO {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] costs= Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] split = in.nextLine().split(" ");
        int[] days=new int[366];
        for (int i = 0; i < split.length; i++) {
            days[Integer.valueOf(split[i])]=1;
        }


        int[] dp=new int[366];
        int[] choose={1,3,7,30};

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 1; i <366 ; i++) {
            if(days[i]==0){
                dp[i]=dp[i-1];
            }else {
                for (int j = 0; j < 4; j++) {
                 dp[i]=Math.min(dp[i],dp[Math.max(0,i-choose[j])]+costs[j]);
                }

            }
        }
        System.out.println(dp[365]);




    }
}

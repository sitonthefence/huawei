package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW8TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int ans=0;
        for (int i = 0; i <array.length ; i++) {
            int temp=array[i];
            if(temp>4) temp--;
            for (int j = 0; j < array.length-i-1; j++) {
                temp*=9;
            }
            ans+=temp;


        }
        System.out.println(ans);

    }
}

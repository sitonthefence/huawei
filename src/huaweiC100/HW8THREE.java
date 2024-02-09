package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW8THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int ans=0;
        for (int i = 0; i <array.length ; i++) {

            if(array[i]>4) array[i]--;
            for (int j = 0; j < array.length-i-1; j++) {
                array[i]*=9;
            }
            ans+=array[i];


        }
        System.out.println(ans);

    }
}

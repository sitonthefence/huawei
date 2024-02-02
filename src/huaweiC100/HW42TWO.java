package huaweiC100;

import java.util.Arrays;
import java.util.Scanner;

public class HW42TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            int[] arr=new int[length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=in.nextInt();
            }
            int minAbility=in.nextInt();
            int ans =0;
            int left=0;
            int right=length-1;
            Arrays.sort(arr);
            while (left<=right&&arr[right]>=minAbility){
                ans++;
                right--;
            }
            while (left<right){

               int sum=arr[left]+arr[right];
               if(sum>=minAbility){
                   ans++;
                   left++;
                   right--;

               }else {
                   left++;
               }



            }

            System.out.println(ans);
        }


    }
}

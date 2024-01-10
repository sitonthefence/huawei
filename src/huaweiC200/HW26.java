package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            Integer month= Integer.valueOf(in.nextLine());
            String source = in.nextLine();
            String[] split = source.split(" ");
            int []arr=new int[split.length];
            for (int i = 0; i <split.length ; i++) {
                arr[i]=Integer.valueOf(split[i]);
            }
            Arrays.sort(arr);
            int left=arr[arr.length-1];
            int right=(int)1e9;
            int target=right;
            while (left<right){
                 int middle=(left+right)/2;
                 if(getMonth(arr,middle)<=month){
                     target=middle;
                     right=middle;

                 }else {
                     left=middle+1;
                 }
            }
            System.out.println(target);
        }
    }
    public static int getMonth(int []arr,int person){

        int ans=0;
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            if(arr[left]+arr[right]<=person){
                left++;
            }
            ans++;
            right--;
        }
        return ans;

    }

}

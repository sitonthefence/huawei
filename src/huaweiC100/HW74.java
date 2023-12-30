package huaweiC100;

import java.util.Scanner;

public class HW74 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int target = in.nextInt();
        int left=0;
        int right=0;
        int currentSum=0;
        int minLength=Integer.MAX_VALUE;
        int arr[]=new int[target-1];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=i+1;
            }
          int a=-1;
            int b=-1;
        while (right<arr.length){
            currentSum+=arr[right];
            while (currentSum>=target){
                if(currentSum==target){
                   if(right-left+1<minLength){
                       minLength=right-left+1;
                       a=left;
                       b=right;
                   }
                }
                currentSum=currentSum-arr[left];
                left++;
            }
            right++;
        }
        if(a==-1){
            System.out.println("N");
            break;
        }
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(target+"=");
            for (int i = a; i <=b ; i++) {
                stringBuilder.append(arr[i]+"+");
            }
            String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
            System.out.println(substring);
        }

    }
}

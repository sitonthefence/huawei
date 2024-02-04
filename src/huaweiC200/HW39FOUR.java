package huaweiC200;



import java.util.Arrays;
import java.util.Scanner;



public class HW39FOUR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine();
        int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int canEat = in.nextInt();
        int right=length-canEat;
        int rightSum=0;
        for (int i = right; i <length ; i++) {
            rightSum+= arr[i];
        }
        if(length==canEat){
            System.out.println(rightSum);
            return;
        }
        int left=0;
        int ans=rightSum;
        int sum=rightSum;
        while (left<canEat){
            sum+= arr[left++]- arr[right++];
            ans=Math.max(ans,sum);
        }
        System.out.println(ans);



    }
}

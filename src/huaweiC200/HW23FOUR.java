package huaweiC200;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class HW23FOUR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] temp = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer[] ball=new Integer[temp.length];
        for (int i = 0; i < ball.length; i++) {
            ball[i]=temp[i];
        }
        int bucketNumber = in.nextInt();
        Arrays.sort(ball, Comparator.reverseOrder());
        int right=Arrays.stream(temp).sum();
        int left = Arrays.stream(temp).max().orElse(0);
        int target=right;
        while (left<right){
            int mid=(left+right)/2;
            int[] bucket=new int[bucketNumber];
            if(dfs(bucket,mid,ball,0)){
                right=mid;
                target=mid;
            }else {
                left=mid+1;
            }
        }
        System.out.println(target);
    }
    public static boolean dfs(int[] bucket,int mid,Integer[] ball,int index){
        if(index==ball.length){
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (i>0&&bucket[i]==bucket[i-1]) continue;
            if(bucket[i]+ball[index]<=mid){
                bucket[i]+=ball[index];
                if(dfs(bucket,mid,ball,index+1)) return true;
                bucket[i]-=ball[index];
            }
        }
        return false;

    }
}

package huaweiC200;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class HW27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int strength = Integer.parseInt(sc.nextLine());
        System.out.println(getResult(heights, strength));
    }

    private static int getResult(int[] heights, int strength) {
        HashSet<Integer> result=new HashSet<>();
        solve(heights,strength,result,true);
        reverse(heights);
        solve(heights,strength,result,false);
        return result.size();
    }
    public static void solve(int[] height,int strength, HashSet<Integer> result, boolean order){
        int j=0;
        while (j<height.length){
            if (height[j]==0){
                break;
            }
            j++;
        }
        int cost=0;
        for (int i = j+1; i <height.length ; i++) {
            if(height[i]==0){
                cost=0;
                continue;
            }
            int dif=height[i]-height[i-1];
            if(dif>0){
                cost+=3*dif;
                if (i==height.length-1||height[i]>height[i+1]){
                    if(strength>cost){
                        if(order){
                            result.add(i);
                        }else {
                            result.add(height.length-1-i);
                        }
                    }

                }
            }else {
                cost-=3*dif;
            }

        }
    }
    public static void reverse(int[] nums){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}


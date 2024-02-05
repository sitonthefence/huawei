package huaweiC200;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class HW27TWO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int strength = Integer.parseInt(sc.nextLine());
        System.out.println(getResult(heights, strength));
    }

    private static int getResult(int[] heights, int strength) {
        HashSet<Integer> set=new HashSet<>();
        climb(heights,strength,set,true);
        reverse(heights);
        climb(heights,strength,set,false);
        return set.size();

    }
    public static void climb(int[] heights, int strength, HashSet<Integer> set,boolean direction){
        int j=0;
        for (; j < heights.length; j++) {
            if(heights[j]==0) break;
        }
        int cost=0;
        for (int i = j+1; i <heights.length ; i++) {
            if(heights[i]==0){
                cost=0;
                continue;
            }
            int dif=heights[i]-heights[i-1];
           if(dif>0){
               cost+=3*dif;
               if (i == heights.length - 1 || heights[i] > heights[i+1]) {
                   if(strength>cost){
                       if(direction){

                           set.add(i);
                       }else {
                           set.add(heights.length-1-i);
                       }

                   }
               }

           }else if(dif<0){
               cost-=3*dif;
           }

        }
    }
    public static void reverse(int[] heights){
         int left=0;
         int right=heights.length-1;
        while (left<right){
            int tmp=heights[left];
            heights[left]=heights[right];
            heights[right]=tmp;
            left++;
            right--;
        }



    }

}


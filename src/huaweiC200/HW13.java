package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.next();
        int target = in.nextInt();
        int[] array = Arrays.stream(source.substring(1, source.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
        Step[] allStep=new Step[array.length];
        for (int i = 0; i < allStep.length; i++) {
            allStep[i]=new Step(array[i],i);
        }
        Arrays.sort(allStep,(a,b)->a.val-b.val);
        int min=Integer.MAX_VALUE;
        Step[] result=new Step[3];
        for (int i = 0; i < allStep.length; i++) {
            if(allStep[i].val>target&&allStep[i].val>0&&target>0) break;
            if(i>0&&allStep[i].val==allStep[i-1].val) continue;
            int left=i+1;
            int right=allStep.length-1;
         while (left<right){
             int midSeparate=(target-allStep[i].val)/2;
             if (allStep[left].val>midSeparate||allStep[right].val<midSeparate) break;
             int currentSum=allStep[i].val+allStep[left].val+allStep[right].val;
             if(currentSum<target){
                 left++;
             }else if (currentSum>target){
                 right--;
             }else {
                 while (left<right-1&&allStep[right].val==allStep[right-1].val) {
                     right--;
                 }
                 int currentIndexSum=allStep[i].index+allStep[left].index+allStep[right].index;
                 if(currentIndexSum<min){
                     min=currentIndexSum;
                     result=new Step[3];
                     result[0]=new Step(allStep[i].val,allStep[i].index);
                     result[1]=new Step(allStep[left].val,allStep[left].index);
                     result[2]=new Step(allStep[right].val,allStep[right].index);
                 }
                 while (left+1<right&&allStep[left].val==allStep[left+1].val){
                     left++;
                 }
                 left++;
                 right--;
             }

         }

        }
        Arrays.sort(result,(a,b)->a.index- b.index);
        System.out.println("["+result[0].val+","+result[1].val+","+result[2].val+"]");





    }
    static class Step{
        int val;
        int index;

        public Step(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
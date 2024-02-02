package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//有问题
public class HW29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            int minAverageLost = Integer.valueOf(in.nextLine());
            String source = in.nextLine();
            String[] split = source.split(" ");
            int[] arr=new int[split.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=Integer.valueOf(split[i]);
            }
            int left=0;
            int right=0;
            int currentAverage=0;
            int max=Integer.MIN_VALUE;
            List<List<Integer>> result=new ArrayList<>();;
            while (right<arr.length){
                currentAverage=getAverage(arr,left,right);
                while (currentAverage>minAverageLost){
                    currentAverage=getAverage(arr,left+1,right);
                    left++;

                }
                if(right-left+1==max)
                {
                    List<Integer> path=new ArrayList<>();
                    path.add(left);
                    path.add(right);
                    result.add(path);

                }else if(right-left+1>max){
                    max=right-left+1;
                    result=new ArrayList<>();
                    List<Integer> path=new ArrayList<>();
                    path.add(left);
                    path.add(right);
                    result.add(path);

                }
                right++;

            }
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i).get(0)+"-");;
                System.out.print(result.get(i).get(1)+" ");;
            }

        }

    }
    public  static int getAverage(int[]arr,int left,int right){
        int sum=0;
        for (int i = left; i <=right ; i++) {
            sum+=arr[i];
        }

        return (int) Math.ceil((double)sum/(right-left+1));


    }
}

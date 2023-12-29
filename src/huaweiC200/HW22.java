package huaweiC200;

import java.util.Scanner;

public class HW22 {
    public static int max=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String nums = in.nextLine();
            String[] numArray = nums.split(" ");
            String colors = in.nextLine();
            String[] colorArray = colors.split(" ");
            boolean[] used=new boolean[numArray.length];
            for (int i = 0; i < numArray.length; i++) {
                used[i]=true;
                dfs(numArray[i],colorArray[i],numArray,colorArray,1,used);
                used[i]=false;
            }
            System.out.println(max);
        }

    }
    public static void dfs(String num,String color, String[] numArray, String[] colorArray,int count,boolean[] used){
           max=Math.max(max,count);

        for (int i = 0; i < numArray.length; i++) {
            if(!used[i]&&(num.equals(numArray[i])||color.equals(colorArray[i]))){
                used[i]=true;
                dfs(numArray[i],colorArray[i],numArray,colorArray,count+1,used);
                used[i]=false;

            }

        }





    }
}

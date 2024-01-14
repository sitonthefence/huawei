package huaweiC200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW39 {
    static int length;
    static int target;
   static List<Integer> banana=new ArrayList<>();
   static int[][] memory;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
             length = in.nextInt();

            for (int i = 0; i < length; i++) {
                banana.add(in.nextInt());
            }
            target=in.nextInt();
            memory=new int[length][length];
            System.out.println(EatBanana(0, length - 1, 0));
        }
    }
    public  static int EatBanana(int left,int right,int count){
             if(count==target){
                 return 0;
             }
             if( memory[left][right]!=0){
                 return  memory[left][right];
             }
             memory[left][right]=Math.max(EatBanana(left+1,right,count+1)+banana.get(left),
                     EatBanana(left,right-1,count+1)+banana.get(right));
     return memory[left][right];
    }

}

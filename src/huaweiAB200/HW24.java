package huaweiAB200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            String[] nums = source.split("\\W");
            List<Integer> numsList=new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                numsList.add(Integer.valueOf(nums[i]));
            }

            String[] operators = source.split("\\w");
            List<String> operatorList=new ArrayList<>();
            for (int i = 0; i < operators.length; i++) {
                if(!operators[i].equals("")){
                    operatorList.add(operators[i]);
                }
            }
            for (int i = 0; i < operatorList.size(); i++) {
                if(operatorList.get(i).equals("$")){
               int tmp=3*numsList.get(i)+numsList.get(i+1)+2;
                 numsList.set(i,tmp);
                 numsList.remove(i+1);
                 operatorList.remove(i);
                 i--;
                }
            }

            for (int i = 0; i < numsList.size()-1; i++) {
                numsList.set(i+1,2*numsList.get(i)+3*numsList.get(i+1)+4);

            }
            System.out.println(numsList.get(numsList.size()-1));
        }
    }
}

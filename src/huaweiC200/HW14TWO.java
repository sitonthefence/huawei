package huaweiC200;

import java.util.Scanner;

public class HW14TWO {
    static  int count;
    static  int employeeNum;
    static  int moonCakeNum;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        employeeNum = in.nextInt();
        moonCakeNum = in.nextInt();
        for (int i = 1; i <=moonCakeNum/employeeNum ; i++) {
           dfs(1,0,i);
        }
        System.out.println(count);


    }
    public static void dfs(int index,int currentSum,int currentEmployeeCake){

        currentSum+=currentEmployeeCake;

        if(currentSum>moonCakeNum||index>employeeNum){
            return;
        }
        if(currentSum==moonCakeNum&&index==employeeNum){
            count++;
        }
        dfs(index+1,currentSum,currentEmployeeCake);
        dfs(index+1,currentSum,currentEmployeeCake+1);
        dfs(index+1,currentSum,currentEmployeeCake+2);
        dfs(index+1,currentSum,currentEmployeeCake+3);

    }
}

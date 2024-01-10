package huaweiC200;

import java.util.Scanner;

public class HW14 {
    static int count=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int employee = in.nextInt();
            int moonCake = in.nextInt();
            for (int i = 1; i <=moonCake/employee ; i++) {
                dfs(employee,1,moonCake,i,0);
            }
            System.out.println(count);
        }
    }
    public static void dfs(int employee,int indexEmployee,int moonCake,int currentCake,int sum ){
        sum+=currentCake;
        if(indexEmployee==employee&&sum==moonCake){
            count++;
        }
        if(sum>=moonCake||indexEmployee==employee){
            return;
        }

        dfs(employee,indexEmployee+1,moonCake,currentCake,sum);
        dfs(employee,indexEmployee+1,moonCake,currentCake+1,sum);
        dfs(employee,indexEmployee+1,moonCake,currentCake+2,sum);
        dfs(employee,indexEmployee+1,moonCake,currentCake+3,sum);
        sum-=currentCake;
    }
}

package huaweiC200;

import java.util.Scanner;

public class HW22TWO {
    public static int max=Integer.MIN_VALUE;
    public  static String[] num;
    public  static String[] color;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        num = in.nextLine().split(" ");
        color = in.nextLine().split(" ");
        boolean[] used=new boolean[num.length];
        for (int i = 0; i < num.length; i++) {
            used[i]=true;
            dfs(1,used,num[i],color[i]);
            used[i]=false;
        }
        System.out.println(max);

    }
    public static void dfs(int count ,boolean[] used,String preNum,String preColor ){
        max=Math.max(max,count);
        for (int i = 0; i < num.length; i++) {
            if(used[i]) continue;
            if(preNum.equals(num[i])||preColor.equals(color[i])){
                used[i]=true;
                dfs(count+1,used,num[i],color[i]);
                used[i]=false;
            }
        }
    }
}

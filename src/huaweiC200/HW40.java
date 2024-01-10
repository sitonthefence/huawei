package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int[] cost =new int[4];
            for (int i = 0; i < cost.length; i++) {
                cost[i]=in.nextInt();
            }
            in.nextLine();
            String source = in.nextLine();
            String[] split = source.split(" ");
            boolean[] visited=new boolean[366];
            for (int i = 0; i < split.length; i++) {
                 visited[Integer.valueOf(split[i])]=true;
            }
            int [] choose={1,3,7,30};
            int[] f=new int[366];
            Arrays.fill(f,Integer.MAX_VALUE);
            f[0]=0;
            for (int i = 1; i <366 ; i++) {
                if(!visited[i]){
                    f[i]=f[i-1];
                }else {
                    for (int j = 0; j < 4; j++) {
                        f[i]=Math.min(f[i],f[Math.max(0,i-choose[j])]+cost[j]);;
                    }
                }
            }
            System.out.println(f[365]);



        }

    }
}

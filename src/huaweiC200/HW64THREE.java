package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW64THREE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str2 = in.next();
        int column = str2.length()+1;
        String str1 = in.next();
        int row = str1.length()+1;
       int [] pre=new int[column];
        for (int i = 0; i < pre.length; i++) {
            pre[i]=i;
        }
        int [] cur=new int[column];
        for (int i = 1; i < row; i++) {
            cur[0]=i;
            for (int j = 1; j <column ; j++) {
                if(str2.charAt(j-1)==str1.charAt(i-1)){
                    cur[j]=pre[j-1]+1;
                }else {
                    cur[j]=Math.min(cur[j-1],pre[j])+1;
                }
            }
            pre= Arrays.copyOf(cur,column);

        }
        System.out.println(cur[column-1]);





    }
}

package huaweiC200;

import java.util.Scanner;

public class HW64TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str1 = in.next();
            String str2 = in.next();
            int m=str2.length();
            int n = str1.length();
            int[] preDp=new int[n+1];
            for (int i = 1; i <=n ; i++) {
                preDp[i]=i;
            }
            int[] CurDp=new int[n+1];
            for (int i = 1; i <=m ; i++) {
                CurDp[0]=i;
                for (int j = 1; j <=n ; j++) {
                        if(str2.charAt(i-1)==str1.charAt(j-1)){
                            CurDp[j]=preDp[j-1]+1;
                        }else {
                            //min注意
                            CurDp[j]=Math.min(CurDp[j-1],preDp[j])+1;
                        }
                    }
                //重点
                System.arraycopy(CurDp,0,preDp,0,n+1);
            }

            System.out.println(CurDp[n]);

        }


    }
}

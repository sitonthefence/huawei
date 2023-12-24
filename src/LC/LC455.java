package LC;

import java.util.Arrays;

public class LC455 {
    public static void main(String[] args) {
        int[] g={10,9,8,7};
        int[] s={5,6,7,8};
        findContentChildren(g,s);
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
         int index=0;
         int count=0;
        for (int i = 0; i < g.length; i++) {
            for (int j = index; j <s.length ; j++) {
                if(s[j]>=g[i]){
                    count++;
                    index=j+1;
                    break;
                }



            }
        }
        return count;

    }




}

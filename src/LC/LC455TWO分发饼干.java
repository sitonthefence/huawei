package LC;

import java.util.Arrays;

public class LC455TWO分发饼干 {
    public static void main(String[] args) {
        int[] g={1,2,3};
        int[] s={1,2,3,4,5};
        findContentChildren(g,s);
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if(index< g.length&&s[i]>=g[index]){
                index++;
            }

        }


        return index;
    }
}

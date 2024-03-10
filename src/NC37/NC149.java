package NC37;

public class NC149 {
    public static void main(String[] args) {
        System.out.println(kmp("ababab", "abababab"));
    }
    public static int kmp (String S, String T) {
        if(S.length()>T.length()) return 0;
        // write code here
        int count=0;
        for (int i = 0; i < T.length(); i++) {
            String substring = T.substring(i);
             if(substring.startsWith(S)){
                 count++;
             }

        }
        return count;

    }


}

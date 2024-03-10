package NC37;

public class NC17 {
    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("ababc"));
    }
    public static int getLongestPalindrome (String A) {
        // write code here

        int max=0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = i+1; j <A.length()+1 ; j++) {
                String a = A.substring(i, j);
                String b = new StringBuilder(a).reverse().toString();
              if(a.equals(b)){
                  max= Math.max(max,j-i);
              }

            }
        }
        return max;



    }



}

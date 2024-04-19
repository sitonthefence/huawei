package LC;

public class LC9回文数 {
    public static void main(String[] args) {

    }
    public  static boolean isPalindrome(int x) {
        String str1 = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder(str1);
        String str2 = stringBuilder.reverse().toString();
        return  str1.compareTo(str2)==0;

    }

}

package LC;

public class LC125验证回文串 {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome("0P");

    }
    public static boolean isPalindrome(String s) {
        String s1 = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String s2 = new StringBuilder(s1).reverse().toString();
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }
}

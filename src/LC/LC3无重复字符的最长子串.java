package LC;

public class LC3无重复字符的最长子串 {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("bbbbb"));


    }
    public static int lengthOfLongestSubstring(String s) {
       int[] count =new int[128];
        int left=0;
        int right=0;
        int max=0;
        while (right<s.length()){
            char c = s.charAt(right);
            count[c]++;
            while (count[c]==2){
                count[s.charAt(left)]--;
                left++;
            }
            max=Math.max(max,right-left+1);
            right++;

        }
        return max;
    }
}

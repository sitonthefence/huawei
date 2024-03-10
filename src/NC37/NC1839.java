package NC37;

public class NC1839 {
    public int longestBeautifulSubstring(String word) {
      int length=1;
      int type=1;
      int max=0;
        for (int i = 1; i < word.length(); i++) {
            if(word.charAt(i)>=word.charAt(i-1)) length++;
            if(word.charAt(i)>word.charAt(i-1)) type++;
            if (type==5){
                max=Math.max(length,max);
            }
            if(word.charAt(i)<word.charAt(i-1)) {
                length=1;
                type=1;
            }
        }
        return max;
    }

}

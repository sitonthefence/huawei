package LC;

public class LC2243计算字符串的数字和 {
    public static void main(String[] args) {
        System.out.println(digitSum("11111222223", 3));
    }
    public static String digitSum(String s, int k) {

        if(s.length()<=k){
            return s;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < s.length()/k; i++) {
            String substring = s.substring(i*k, (i+1) * k);
            int sum= 0;
            for (int j = 0; j < substring.length(); j++) {
                sum+=substring.charAt(j)-'0';
            }
            stringBuilder.append(sum);
        }
        if(s.length()%k!=0){
            String substring = s.substring(s.length()/k*k);
            int sum= 0;
            for (int j = 0; j < substring.length(); j++) {
                sum+=substring.charAt(j)-'0';
            }
            stringBuilder.append(sum);
        }
        return digitSum(stringBuilder.toString(),k);

    }




}

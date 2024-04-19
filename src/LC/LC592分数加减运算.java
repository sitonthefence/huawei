package LC;

public class LC592分数加减运算 {

    public String fractionAddition(String expression) {
        // 将字符串中的-替换成"+-", 这样方便后面进行切分
        String eStr = expression.replaceAll("-", "+-");
        // 按照 + 进行切分
        String[] arr = eStr.split("\\+");
        int size = arr.length;
        int sum1 = 0, sum2 = 1;
        // 对分组数据进行通分
        for(int i = 0; i < size; i++) {
            if (arr[i].isEmpty()) {
                continue;
            }
            String[] nums = arr[i].split("/");
            int m =Integer.parseInt(nums[1]);
            int n = Integer.parseInt(nums[0]);
            sum1 = sum1 * m + sum2 * n;
            sum2 *= Integer.parseInt(nums[1]);

        }
        // 辗转相除法, 计算出sum1 和 sum2的最大公约数
        int c = Math.abs(gcd(sum1, sum2));
        // 将sum2的符号提前
        if(sum2 < 0) {
            sum2 = - sum2;
            sum1 = - sum1;
        }
        return sum1 / c + "/" + sum2 / c;

    }
    // 辗转相除法
    public int gcd(int x, int y){
       while (y!=0){
           int temp=y;
           y=x%y;
           x=temp;
       }
       return x;
    }

}

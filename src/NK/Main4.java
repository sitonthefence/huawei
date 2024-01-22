package NK;


public class Main4 {
    static int max_user = 0;
    static int D = 30;
    public static void main(String[] args) {
        int R = 5;
        int[] num = new int[] {10, 5, 0, 1, 3, 2};
        int[] numss = new int[R + 1];
        for (int i = 0; i < numss.length; i++) {
            numss[i] = (int) Math.pow(2, i);
        }

        max_people(numss, num, 0, 5);
        System.out.println(max_user);
    }

    public static void max_people(int[] numss, int[] num, int sum, int len) {
        if (sum >= D) {
            max_user++;
            return;
        }
        for (int i = len; i >= 0 && num[i] >= 0;) {
            if (num[i] == 0) {
                i--;
                continue;
            }
            sum += numss[i];
            if (sum < D) {
                num[i]--;
                max_people(numss, num, sum, i);
            } else {
                sum = 0;
                num[i]--;
                max_user++;
            }
        }
    }
}

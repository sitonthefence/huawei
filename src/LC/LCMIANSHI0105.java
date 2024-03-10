package LC;

public class LCMIANSHI0105 {
    public static void main(String[] args) {
        System.out.println(oneEditAway("intention", "execution"));
    }
    public static boolean oneEditAway(String first, String second) {
        int p1 = 0;
        int q1 = first.length() - 1;
        int p2 = 0;
        int q2 = second.length() - 1;
        while (p1 <= q1 && p2 <= q2) {
            if (first.charAt(p1) ==second.charAt(p1)) {
                ++p1;
                ++p2;
                continue;
            }
            if (first.charAt(q1)== second.charAt(q2)) {
                --q1;
                --q2;
            } else {
                break;
            }
        }
        return q1 - p1 + q2 - p2 <= 0 && Math.abs(p1 - p2) <= 1 && Math.abs(q1 - q2) <= 1;

    }
}

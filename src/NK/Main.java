package NK;
import java.util.*;

public class Main {
    private static final Scanner s = new Scanner(System.in);


    public static void main(String[] args) {
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = s.nextInt();
            Arrays.sort(a);
            System.out.println(f(a, 0));
        }
        s.close();
    }

    public static int f(int[] a, int i) {
        int res = 0;
        for (int j = i; j < a.length - 2; j++) {
            int x = a[j];
            if (x == 0) continue;
            for (int k = j + 1; k < a.length - 1; k++) {
                int y = a[k];
                if (y == 0) continue;
                for (int l = k + 1; l < a.length; l++) {
                    int z = a[l];
                    if (z == 0) continue;
                    if (x * x + y * y == z * z) {
                        a[j] = a[k] = a[l] = 0;
                        res = Math.max(res, f(a, j + 1) + 1);
                        a[j] = x;
                        a[k] = y;
                        a[l] = z;
                        if (res == 3) return res;
                    }
                }
            }
        }
        return res;
    }
}

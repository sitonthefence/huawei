package NK;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.valueOf(in.nextLine());
        List<int[]> list = new ArrayList<int[]>();
        int min = 1;
        int max = 1;
        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            min = Math.min(s, min);
            max = Math.max(e, max);
            list.add(new int[] {s, e});
        }
        System.out.println(list.size());

    }
}
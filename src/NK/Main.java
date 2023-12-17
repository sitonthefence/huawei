package NK;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] heights = input.split(",");
        int[] zhizhu_heights = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            zhizhu_heights[i] = Integer.parseInt(heights[i]);
        }

        int max_area = 0;

        for (int i = 0; i < zhizhu_heights.length - 1; i++) {
            for (int j = i + 1; j < zhizhu_heights.length; j++) {
                int distance = j - i;
                int height = Math.min(zhizhu_heights[i], zhizhu_heights[j]);
                int area = distance * height;
                max_area = Math.max(max_area, area);
            }
        }

        System.out.println(max_area);
    }
}





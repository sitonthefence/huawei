package TEST;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {

    private static List<String> resultList = new ArrayList<>();
    private static int currentLen = 0;
    private static int getListSum(List<Integer> list, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += list.get(i);
        }
        return sum;
    }
    private static void getPeriod(int minAvg, List<Integer> list) {
        resultList.clear();
        currentLen = 0;
        for (int start = 0; start < list.size() - 1; ++start) {
            for (int end  = start + 1; end < list.size(); ++end) {
                int sum = getListSum(list, start, end);
                String result = "";
                int length = end - start + 1;
                if (sum == 0 && minAvg >= 0) {
                    result = start + "-" + end;
                } else {
                    if (sum <= minAvg * length) {
                        result = start + "-" + end;
                    }
                }
                if (result.contains("-")) {
                    if (length == currentLen) {
                        resultList.add(result);
                    }
                    if (length > currentLen) {
                        resultList.clear();
                        resultList.add(result);
                        currentLen = length;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            while (s.hasNextLine()) {
                int minAvg = Integer.parseInt(s.nextLine().trim());
                String[] strs = s.nextLine().trim().split(" ");
                List<Integer> listValues = new ArrayList<Integer>();
                for (int i = 0; i < strs.length; i++) {
                    listValues.add(Integer.parseInt(strs[i]));
                }
                getPeriod(minAvg, listValues);
                if (!resultList.isEmpty()) {
                    for (int i = 0; i < resultList.size(); i++) {
                        System.out.print(resultList.get(i));
                        System.out.print(" ");
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
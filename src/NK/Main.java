package NK;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    // 输入获取
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<String> lines = new LinkedList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if ("".equals(line)) {
                System.out.println(getResult(lines));
                sc.close();
                break;
            } else {
                lines.add(line);
            }
        }
    }

    // 算法入口
    public static int getResult(LinkedList<String> lines) {
        StringBuilder sb = new StringBuilder();

        for (String line : lines) {
            line =
                    line.replaceAll("\\\\[\"']", "") // 替换\"和\'为空串
                            .replaceAll("\".*?\"", "a") // 将成对双引号及其中内容替换为空串
                            .replaceAll("'.*?'", "a") // 将成对单引号及其中内容替换为空串
                            .replaceAll("-.+", "") // 将-往后的注释替换为空串
                            .replaceAll("\\s+", "") // 将空白字符替换为空串
                            .replaceAll(";+", ";"); // 将连续分号替换为单个分号

            sb.append(line);
        }

        // 题目描述说：文本以”;”分隔，最后一条可以没有”;”
        // 为了避免复杂处理，这里无论最后一条文本有没有分号，都加一个
        sb.append(";");

        // 下面处理主要是为了处理跨行文本
        /***
         * 比如
         * aaaa;
         * ;aaaa
         *
         * 比如
         * ;aaaa
         * ;aaaa
         */
        String s = sb.toString().replaceAll(";+", ";").replaceAll("^;", "");

        // 记录文本条数
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ';') count++;
        }

        return count;
    }
}
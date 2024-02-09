package NK;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 将文件内容压缩为一行，换行使用换行符\n代替
        StringJoiner sj = new StringJoiner("\n");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            // 本地测试时，以输入空行作为结束条件，实际考试时无需此逻辑
            //      if (line.length() == 0) break;

            sj.add(line);
        }

        System.out.println(getResult(sj.toString()));
    }

    public static int getResult(String s) {
        // 记录题解，即文件中包含的文本数量
        int ans = 0;

        // 当前文本的"非空"内容长度
        int content_length = 0;

        // 单引号开闭状态，当前解法默认单引号必然成对出现
        boolean sq_flag = false;
        // 双引号开闭状态，当前解法默认双引号必然成对出现
        boolean dq_flag = false;

        // 定义一个指针 i 用于扫描文件内容
        int i = 0;

        while (i < s.length()) {
            // 当前正在被扫描的字符
            char c = s.charAt(i);

            switch (c) {
                case '\\': // 如果扫描到转义\符号，则自动跳过转义符号及其后面的转义字符
                    i++;
                    break;
                case '\"': // 如果扫描到双引号
                    if (!sq_flag) { // 如果该双引号不在成对单引号内部
                        dq_flag = !dq_flag; // 则双引号开闭状态取反
                    }
                    break;
                case '\'': // 如果扫描到单引号
                    if (!dq_flag) { // 如果该单引号不在成对双引号内部
                        sq_flag = !sq_flag; // 则单引号开闭状态取反
                    }
                    break;
                case '-': // 如果扫描到 '-' ，则可能是注释符号，也可能不是
                    if (!sq_flag && !dq_flag) { // 如果该 '-' 处于成对双向号，或成对单引号内部，则不是注释符号，否则可能是注释符号
                        if (++i < s.length() && s.charAt(i) == '-') { // 如果该 '-' 后面紧跟着的字符还是 '-'，则确定当前遇到注释符号
                            while (++i < s.length() && s.charAt(i) != '\n') {} // 注释符号后面的内容（直到行末）都不算文本，即不会增加文本数量
                        }
                    }
                    break;
                case ';': // 如果扫描到 ';'
                    if (!sq_flag & !dq_flag && content_length > 0) { // 该分号不处于成对单引号或成对双引号内部，且分号前存在非空内容
                        ans++; // 则文本数量++
                        content_length = 0; // 继续统计下一个文本
                    }
                    break;
                default: // 如果扫描到其他字符，且该字符非空白字符，则非空文本内容长度++
                    if (!Character.isWhitespace(c)) {
                        content_length++;
                    }
                    break;
            }

            // 继续扫描下一个字符
            i++;
        }

        // 题目说最后一个文本可以没有分号，即最后的文本只有存在非空内容，即为一个文本
        if (content_length > 0) {
            ans++;
        }

        return ans;
    }
}
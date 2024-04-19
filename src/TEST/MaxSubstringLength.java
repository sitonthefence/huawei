package TEST;


 import java.util.HashMap;

    public class MaxSubstringLength {
        public static int maxLengthOfSubstring(String s) {
            // 创建一个HashMap来存储字符和它们在字符串中的索引
            HashMap<Character, Integer> charIndexMap = new HashMap<>();
            int maxLength = 0; // 最大子串长度
            int start = 0; // 子串的起始索引

            // 遍历字符串
            for (int end = 0; end < s.length(); end++) {
                char currentChar = s.charAt(end);
                // 如果当前字符已经在HashMap中存在，并且其索引大于等于起始索引
                if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                    // 更新起始索引为重复字符的下一个位置
                    start = charIndexMap.get(currentChar) + 1;
                }
                // 将当前字符及其索引加入HashMap
                charIndexMap.put(currentChar, end);
                // 更新最大子串长度
                maxLength = Math.max(maxLength, end - start + 1);
            }

            return maxLength;
        }

        public static void main(String[] args) {
            String input = "pwwkew";
            int result = maxLengthOfSubstring(input);
            System.out.println("最大不重复子串长度为：" + result); // 输出最大不重复子串长度
        }
    }

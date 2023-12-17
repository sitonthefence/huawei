package NK;
import java.util.ArrayList;
import java.util.List;

class Solution {
    private final String[] letterMap = {
            "",    // 0
            "",    // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    private List<String> result;
    private StringBuilder s;

    public List<String> letterCombinations(String digits) {
        s = new StringBuilder();
        result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        backtracking(digits, 0);

        return result;
    }

    private void backtracking(String digits, int index) {
        if (index == digits.length()) {
            result.add(s.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = letterMap[digit];

        for (int i = 0; i < letters.length(); i++) {
            s.append(letters.charAt(i));
            backtracking(digits, index + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }
}





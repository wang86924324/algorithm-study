package homework.week5;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        String path = "";
        doCombinations(digits.toCharArray(), path, res);
        return res;
    }

    private void doCombinations(char[] digits, String path, List<String> res) {
        if (digits.length == path.length()) {
            res.add(path);
            return;
        }

        for (char c : KEYS[digits[path.length()] - '0'].toCharArray()) {
            doCombinations(digits, path + c, res);
        }
    }


}

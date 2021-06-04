import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LeetCode 17
public class LetterCombinationsOfAPhoneNumber {
    Map<Integer, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mn0");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] array = digits.toCharArray();
        dfs(array, sb, 0, res, map);
        return res;
    }

    private void dfs(char[] array, StringBuilder sb, int index, List<String> res, Map<Integer, String> map) {
        if(index == array.length) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i <map.get(array[index] - '0').length(); i++) {
            sb.append(map.get(array[index] - '0').charAt(i));
            dfs(array, sb, index + 1, res, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main (String[] args) {
        LetterCombinationsOfAPhoneNumber test = new LetterCombinationsOfAPhoneNumber();
        String digits = "23";
        System.out.println(test.letterCombinations(digits));
    }
}

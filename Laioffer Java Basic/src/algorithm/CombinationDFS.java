package algorithm;

import java.util.ArrayList;
import java.util.List;

// LaiCode 62 - All Subsets I
public class CombinationDFS {
    public List<String> combination(String input) {
        List<String> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            result.add("");
            return result;
        }

        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(array, 0, sb, result);
        return result;
    }

    private void dfs(char[] array, int index, StringBuilder sb, List<String> result) {
        if (index == array.length) {
            result.add(sb.toString());
            return;
        }

        sb.append(array[index]);
        dfs(array, index + 1, sb, result);
        sb.deleteCharAt(sb.length() -1);
        dfs(array, index + 1, sb, result);
    }

    public static void main(String[] args) {
        CombinationDFS test = new CombinationDFS();
        String input = "abcd";
        System.out.println(test.combination(input));
    }
}

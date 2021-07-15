//public class Solution {
//    public List<String> permutations(String input) {
//        List<String> res = new ArrayList<>();
//        if (input.length() == 0) {
//            res.add("");
//            return res;
//        }
//
//        char[] array = input.toCharArray();
//        dfs(array, 0, res);
//        return res;
//    }
//
//    private void dfs(char[] array, int position, List<String> res) {
//        if (position == array.length) {
//            res.add(new String(array));
//            return;
//        }
//
//        for (int i = position; i < array.length; i++) {
//            swap(array, i, position);
//            dfs(array, position + 1, res);
//            swap(array, i, position);
//        }
//    }
//
//    private void swap(char[] array, int i, int j) {
//        char temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
//}
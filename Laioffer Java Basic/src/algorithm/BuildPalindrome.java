import java.util.ArrayDeque;
import java.util.Deque;

public class BuildPalindrome {
    public String buildPalindrome(String st) {
//        if (st == null || st.length() <= 1) {
//            return st;
//        }
//
//        char[] array = st.toCharArray();
//        Deque<Character> stack = new ArrayDeque<>();
//        int left = 0;
//        int right = st.length() - 1;
//        while (left <= right) {
//            if (array[left] != array[right]) {
//                stack.push(array[left]);
//                left++;
//            } else {
//                left++;
//                right--;
//            }
//        }
//        StringBuilder sb = new StringBuilder(st);
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop());
//        }
//        return sb.toString();

        if(st.equals(new StringBuilder(st).reverse().toString())) {
            return st;
        }
        for (int i = 0; i < st.length(); ++i) {
            String str = st;
            str += new StringBuilder(st.substring(0, i)).reverse().toString();
            if (str.equals(new StringBuilder(str).reverse().toString())) {
                st = str;
                break;
            }
        }
        return st;
    }

    public static void main(String[] args) {
        BuildPalindrome test = new BuildPalindrome();
        System.out.println(test.buildPalindrome("abcabc"));
    }
}

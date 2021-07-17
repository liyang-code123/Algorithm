package ov;

// HealthCrowd OA
public class MinimumAddParenthesis {
    public int minAddParenthesis(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                i++;
            } else {
                if (i == 0 || s.charAt(i - 1) == ')') {
                    min++;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumAddParenthesis test = new MinimumAddParenthesis();
        String s = "())))";
        System.out.println(test.minAddParenthesis(s));
    }
}

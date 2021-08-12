public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            if (array[i] != array[j]) {
                return helper(array, i++, j) || helper(array, i, j--);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean helper(char[] array, int i, int j) {
        while (i <= j) {
            if (array[i] != array[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome test = new ValidPalindrome();
        System.out.println(test.isPalindrome("abbcba"));
    }
}

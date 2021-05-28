package algorithm2;

//LaiCode 88
public class ArrayHopper {
    public boolean canJump(int[] array) {
        boolean[] dp = new boolean[array.length];
        dp[0] = true;

        for (int i = 1; i < array.length; i++) {
            for (int j = i + 1; j <= array.length; j++) {
                if (dp[i] && j <= i + array[i]) {
                    dp[j] = true;
                }
            }
        }
        return dp[array.length - 1];
    }

    public static void main (String[] args) {
        ArrayHopper test = new ArrayHopper();
        int[] array = {1, 2, 0, 3, 4, 1};
        System.out.println(test.canJump(array));
    }
}

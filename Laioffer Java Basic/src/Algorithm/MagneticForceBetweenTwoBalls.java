import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 0;
        int right = position[position.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPut(position, m, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canPut(int[] position, int m, int max) {
        int count = 0;
        int last = position[0];
        for (int j : position) {
            if (j - last >= max) {
                last = j;
                count++;
            }
        }
        return count >= m;
    }

    public static void main(String[] args) {
        MagneticForceBetweenTwoBalls test = new MagneticForceBetweenTwoBalls();
        int[] position = new int[]{1, 2, 3, 5, 4, 7};
        int m = 4;
        System.out.println(test.maxDistance(position, m));
    }
}

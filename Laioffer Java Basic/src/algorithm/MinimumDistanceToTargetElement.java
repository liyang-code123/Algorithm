package algorithm;

public class MinimumDistanceToTargetElement {
    public int min(int[] array, int target, int start) {
        if (array == null || array.length == 0) return -1;
        int minStep = 0;
        for (int i = 0; i < array.length; i++) {
            minStep = Math.min(minStep, Math.abs(i - start));
        }
        return minStep;
    }
}

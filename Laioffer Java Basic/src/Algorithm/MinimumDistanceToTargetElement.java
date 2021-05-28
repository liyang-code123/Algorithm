package algorithm2;

public class MinimumDistanceToTargetElement {
    public int min(int[] array, int target, int start) {
        if (array == null || array.length == 0) return -1;
        int minStep = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                minStep = Math.min(minStep, Math.abs(i - start));
            }
        }
        return minStep;
    }

    public static void main (String[] args) {
        MinimumDistanceToTargetElement test = new MinimumDistanceToTargetElement();
        int[] array = {1, 2, 5, 3, 5, 7, 2, 4, 5, 5};
        int target = 5;
        int start = 3;
        System.out.println(test.min(array, target, start));
    }
}

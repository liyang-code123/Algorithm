package algorithm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// LeetCode 56
public class MergeIntervals {
    public int[][] mergeIntervals(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] cur = intervals[0];
        result.add(cur);
        for (int[] interval : intervals) {
            if (interval[0] <= cur[1]) {
                cur[1] = Math.max(interval[0], cur[1]);
            } else {
                result.add(cur);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main (String[] args) {
        MergeIntervals test = new MergeIntervals();
        int[][] intervals= {{1, 2}, {1, 4}, {3,4}, {2, 3}};
        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(test.mergeIntervals(intervals)[i]));
        }
    }
}

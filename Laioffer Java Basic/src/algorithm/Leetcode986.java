import java.util.ArrayList;
import java.util.List;

public class Leetcode986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null && secondList == null) {
            return new int[][]{{}};
        }
        if (firstList == null) {
            return secondList;
        }
        if (secondList == null) {
            return firstList;
        }

        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);
            if (low <= high) {
                list.add(new int[]{low, high});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        int length = list.size();
        int[][] res = new int[length][2];
        for (int k = 0; k < length; k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}

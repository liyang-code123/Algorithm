public class PaintHouseII {

    public int paintHouseII (int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int n = costs.length;
        int k = costs[0].length;
        for (int house = 1; house < n; house++) {
            for (int color = 0; color < k; color++) {
                int min = Integer.MAX_VALUE;
                for (int preColor = 0; preColor < k; preColor++) {
                    if(color == preColor) continue;
                    min = Math.min(min, costs[house - 1][preColor]);
                }
                costs[house][color] += min;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int c : costs[n - 1]) {
            res = Math.min(res, c);
        }
        return res;
    }
}

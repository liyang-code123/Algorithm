package algorithm;

import jdk.internal.net.http.common.Pair;

import java.util.HashMap;

// LeetCode 787
public class CheapestFlightsWithinKStops {
    private int[][] adjMatrix;
    private HashMap<Pair<Integer, Integer>, Long> memo;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        adjMatrix = new int[n][n];
        memo = new HashMap<Pair<Integer, Integer>, Long>();

        for (int[] flight : flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        long ans = findShortest(src, k, dst, n);
        return ans >= Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public long findShortest(int node, int stops, int dst, int n) {
        if (node == dst) {
            return 0;
        }

        if (stops < 0) {
            return Integer.MAX_VALUE;
        }

        Pair<Integer, Integer> key = new Pair<Integer, Integer>(node, stops);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long ans = Integer.MAX_VALUE;
        for (int neighbor = 0; neighbor < n; ++neighbor) {
            int weight = adjMatrix[node][neighbor];
            if (weight > 0) {
                ans = Math.min(ans, findShortest(neighbor, stops - 1, dst, n) + weight);
            }
        }
        memo.put(key, ans);
        return ans;
    }
}

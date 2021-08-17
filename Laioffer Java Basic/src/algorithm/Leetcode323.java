import java.util.ArrayList;
import java.util.List;

public class Leetcode323 {
    public int numberOfComponent(int n, int[][] edges) {
        if (n <= 1) {
            return 1;
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                dfs(list, i, visited);
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> list, int cur, boolean[] visited) {
        for (int next : list.get(cur)) {
            if (!visited[next]){
                dfs(list, next, visited);
                visited[next] = true;
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponents {
    public int numberOfIsland(int n, int[][] edges) {
        if (n <= 1) {
            return 1;
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(list, visited,n, i);
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> list, boolean[] visited, int n, int i) {
        if (i == n) {
            return;
        }
        for (int next : list.get(i)) {
            if (!visited[i]) {
                visited[next] = true;
                dfs(list, visited, n, next);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfConnectedComponents test = new NumberOfConnectedComponents();
        int n = 5;
        int[][] edges = {{0,1}, {1, 2}, {3, 4}};
        System.out.println(test.numberOfIsland(n, edges));
    }
}

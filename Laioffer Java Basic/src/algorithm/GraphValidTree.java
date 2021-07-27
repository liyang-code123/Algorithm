import java.util.ArrayList;
import java.util.List;

// Leetcode 261
public class GraphValidTree {
    public boolean isTree(int n, int[][] edges) {
        if (n <= 1) {
            return true;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if (hasCycle(adjList, visited, 0, -1)) {
            return false;
        }


        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> adjList, boolean[] visited, int cur, int parent) {
        visited[cur] = true;

        List<Integer> neighbors = adjList.get(cur);
        for (int nb : neighbors) {
            if (visited[nb] && parent != nb || !visited[nb] && hasCycle(adjList, visited, nb, cur)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphValidTree test = new GraphValidTree();
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(test.isTree(n, edges));
    }
}

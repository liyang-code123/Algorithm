package algorithm2;

import java.util.*;

public class GymEquipmentChair {
    private static final char EQUIP = 'E';
    private static final char OB = 'O';
    public List<Integer> putChair(char[][] gym) {
        int M = gym.length;
        int N = gym[0].length;
        int[][] cost = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (EQUIP == gym[i][j]) {
                    addCost(cost, gym, i, j);
                    // if (!addCost(cost, gym, i, j)) {
                    //   // int[] arr = new int[]{-1, -1};
                    //   List<Integer> res = Arrays.asList(-1, -1);
                    //   return res;
                    //   // return null;
                    // }
                }
            }
        }

        List<Integer> result = null;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (EQUIP != gym[i][j] && OB != gym[i][j]) {
                    if (result == null) {
                        result = Arrays.asList(i, j);
                    } else if (cost[i][j] < cost[result.get(0)][result.get(1)]) {
                        result.set(0, i);
                        result.set(1, j);
                    }
                }
            }
        }
        if (result == null) {
            return Arrays.asList(-1, -1);
        }
        return result;
    }

    private boolean addCost(int[][] cost, char[][] gym, int i, int j) {
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        int pathCost = 1;
        Queue<Pair> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.offer(new Pair(i, j));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pair cur = queue.poll();
                List<Pair> neighbors = getNeighbors(cur, gym);
                for (Pair neighbor : neighbors) {
                    if (!visited[neighbor.i][neighbor.j]) {
                        visited[neighbor.i][neighbor.j] = true;
                        cost[neighbor.i][neighbor.j] += pathCost;
                        queue.offer(neighbor);
                    }
                }
            }
            pathCost++;
        }

        // for (int k = 0; k < gym.length; k++) {
        //   for (int l = 0; l < gym[0].length; l++) {
        //     if (!visited[k][l] && EQUIP == gym[k][l]) {
        //       return false;
        //     }
        //   }
        // }
        return true;
    }

    private List<Pair> getNeighbors(Pair cur, char[][] gym) {
        int x = cur.i;
        int y = cur.j;
        int M = gym.length;
        int N = gym[0].length;
        List<Pair> neighbors = new ArrayList<>();
        if (x + 1 < M && OB != gym[x + 1][y]) {
            neighbors.add(new Pair(x + 1, y));
        }
        if (y + 1 < N && OB != gym[x][y + 1]) {
            neighbors.add(new Pair(x, y + 1));
        }
        if (x - 1 >= 0 && OB != gym[x - 1][y]) {
            neighbors.add(new Pair(x - 1, y));
        }
        if (y - 1 >= 0 && OB != gym[x][y - 1]) {
            neighbors.add(new Pair(x, y - 1));
        }
        return neighbors;
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

package algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

//LeetCode 1197
public class MinimumKnightMoves {
    final int[][] DIR = {{-1, -2}, {-1, 2}, {-2, -1}, {-2, 1}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) return 0;
        int steps = 0;
        return bfs(x, y, steps);
    }

    public int bfs(int x, int y, int steps) {
        boolean[][] visited = new boolean[605][605];
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(0, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            Pair cur = queue.poll();
            for (int i = 0; i < size; i++) {
                if (cur.x == x && cur.y == y) {
                    return steps;
                }
                for (int[] direction : DIR) {
                    Pair next = new Pair(cur.x + direction[0], cur.y + direction[1]);
                    if (!visited[next.x + 302][next.y + 302]) {
                        visited[next.x + 302][next.y + 302] = true;
                        queue.offer(next);
                    }
                }
            }
            steps++;
        }
        return steps;
    }

    private class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        MinimumKnightMoves test = new MinimumKnightMoves();
        int x = 1;
        int y = 2;
        System.out.println(test.minKnightMoves(x, y));
    }
}

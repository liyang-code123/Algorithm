package algorithm2;

import java.util.HashSet;
import java.util.Set;

public class UnionFindII {
    public int countComponents(int n, int[][] edges) {
        int[] pre = new int[n];
        Set<Integer> count = new HashSet<>();
        for (int i = 0; i < n; i++) {
            pre[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], pre);
        }
        for (int x : pre) {
            count.add(find(x, pre));
        }
        return count.size();
    }

    public int find(int x, int[] pre) {
        int r = x;
        while (r != pre[r]) {
            r = pre[r];
        }
        int cur = x;
        while (pre[cur] != r) {
            x = pre[cur];
            pre[cur] = r;
            cur = x;
        }
        return r;
    }

    public void union(int x, int y, int[] pre) {
        int px = find(x, pre);
        int py = find(y, pre);
        pre[py] = px; // update root
    }

    public static void main(String[] args) {
        UnionFindII uf2 = new UnionFindII();
        int a = 5;
        int[][] b = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(uf2.countComponents(a, b));
    }
}

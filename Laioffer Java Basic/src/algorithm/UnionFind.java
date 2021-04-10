package algorithm;

public class UnionFind {
    public int unionFind(int n, int[][] edges) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int rep1 = find(array, edges[i][0]);
            int rep2 = find(array, edges[i][1]);
            if (rep1 != rep2) {
                array[rep1] = rep2;
                n--;
            }
        }
        return n;
    }

    private int find(int[] array, int value) {
        while(array[value] != value) {
            value = array[value];
        }
        return value;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        int a = 5;
        int[][] b = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(uf.unionFind(a, b));
    }
}

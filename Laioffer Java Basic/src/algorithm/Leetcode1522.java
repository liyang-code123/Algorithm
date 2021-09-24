import java.util.List;

public class Leetcode1522 {
    class Node {
        public int val;
        public List<Node> children;

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
    public int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int[] res = new int[1];
        getHeight(root, res);
        return res[0];
    }

    public int getHeight(Node root, int[] res) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        for (Node child : root.children) {
            int height = getHeight(child, res);
            res[0] = Math.max(res[0], height + max);
            max = Math.max(max, height);
        }
        return max + 1;
    }
}

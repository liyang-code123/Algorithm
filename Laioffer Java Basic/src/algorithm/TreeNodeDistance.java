public class TreeNodeDistance {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int distance(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return -1;
        }

        if(node1.val == node2.val) {
            return 0;
        }

        int[] LCALevel = {-1};
        int[] aLevel = {-1};
        int[] bLevel = {-1};
        helper(root, node1, node2, LCALevel, aLevel, bLevel, 0);
        if (LCALevel[0] != -1) {
            return aLevel[0] + bLevel[0] - 2 * LCALevel[0];
        } else {
            return Math.abs(aLevel[0] - bLevel[0]);
        }
    }

    private int helper(TreeNode root, TreeNode a, TreeNode b, int[] LCALevel, int[] aLevel, int[] bLevel, int level) {
        if (root == null) {
            return -1;
        }

        int left = helper(root.left, a, b, LCALevel, aLevel, bLevel, level + 1);
        int right = helper(root.right, a, b, LCALevel, aLevel, bLevel, level + 1);

        if (left != - 1 && right != -1) {
            LCALevel[0] = level;
            return level;
        } else if (root == a) {
            aLevel[0] = level;
            return level;
        } else if (root == b) {
            bLevel[0] = level;
            return level;
        }
        return left == -1 ? right : left;
    }

    public static void main(String[] args) {
        TreeNodeDistance test = new TreeNodeDistance();
        TreeNode root = new TreeNode(4);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(7);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(test.distance(root, d, b));
    }
}

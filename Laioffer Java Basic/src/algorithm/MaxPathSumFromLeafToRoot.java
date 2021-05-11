package algorithm;

//LaiCode 639
public class MaxPathSumFromLeafToRoot {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode (int val) {
            this.val = val;
        }
    }
    public int maxPathSumFromLeafToRoot(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return root.val;
        if (root.left == null) return maxPathSumFromLeafToRoot(root.right) + root.val;
        if (root.right == null) return maxPathSumFromLeafToRoot(root.left) + root.val;
        return Math.max(maxPathSumFromLeafToRoot(root.left), maxPathSumFromLeafToRoot(root.right)) + root.val;
    }

    public static void main (String[] args) {
        MaxPathSumFromLeafToRoot test = new MaxPathSumFromLeafToRoot();
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(-3);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(-5);
        TreeNode e = new TreeNode(10);
        TreeNode f = new TreeNode(4);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(test.maxPathSumFromLeafToRoot(root));
    }
}

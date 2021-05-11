package algorithm;

//LaiCode 138
public class MaxPathSumFromLeafToLeaf {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode (int val) {
            this.val = val;
        }
    }
    public int maxPathSum (TreeNode root) {
        if (root == null) return -1;
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        helper(root, res);
        return res[0];
    }

    public int helper(TreeNode root, int[] res) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int leftSum = helper(root.left, res);
        int rightSum = helper(root.right, res);
        if (root.left != null && root.right != null) {
            int sum = leftSum + rightSum + root.val;
            res[0] = Math.max(res[0], sum);
            return Math.max(leftSum, rightSum) + root.val;
        }
        return root.left == null ? rightSum + root.val : leftSum + root.val;
    }

    public static void main (String[] args) {
        MaxPathSumFromLeafToLeaf test = new MaxPathSumFromLeafToLeaf();
        MaxPathSumFromLeafToLeaf.TreeNode root = new MaxPathSumFromLeafToLeaf.TreeNode(3);
        MaxPathSumFromLeafToLeaf.TreeNode a = new MaxPathSumFromLeafToLeaf.TreeNode(4);
        MaxPathSumFromLeafToLeaf.TreeNode b = new MaxPathSumFromLeafToLeaf.TreeNode(-3);
        MaxPathSumFromLeafToLeaf.TreeNode c = new MaxPathSumFromLeafToLeaf.TreeNode(2);
        MaxPathSumFromLeafToLeaf.TreeNode d = new MaxPathSumFromLeafToLeaf.TreeNode(-5);
        MaxPathSumFromLeafToLeaf.TreeNode e = new MaxPathSumFromLeafToLeaf.TreeNode(10);
        MaxPathSumFromLeafToLeaf.TreeNode f = new MaxPathSumFromLeafToLeaf.TreeNode(4);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(test.maxPathSum(root));
    }
}

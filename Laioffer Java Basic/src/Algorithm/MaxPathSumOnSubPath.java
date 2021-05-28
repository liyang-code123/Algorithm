package algorithm2;

//LaiCode 140
public class MaxPathSumOnSubPath {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int maxPathSumOnSubPath(TreeNode root) {
        if (root == null) return -1;
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode root, int[] res) {
        if (root == null) return 0;
        int leftSum = helper(root.left, res);
        int rightSum = helper(root.right, res);
        int prefix = Math.max(Math.max(leftSum, rightSum), 0) + root.val;
        res[0] = Math.max(prefix, res[0]);
        return prefix;
    }

    public static void main (String[] args) {
        MaxPathSumOnSubPath test = new MaxPathSumOnSubPath();
        MaxPathSumOnSubPath.TreeNode root = new MaxPathSumOnSubPath.TreeNode(3);
        MaxPathSumOnSubPath.TreeNode a = new MaxPathSumOnSubPath.TreeNode(4);
        MaxPathSumOnSubPath.TreeNode b = new MaxPathSumOnSubPath.TreeNode(3);
        MaxPathSumOnSubPath.TreeNode c = new MaxPathSumOnSubPath.TreeNode(2);
        MaxPathSumOnSubPath.TreeNode d = new MaxPathSumOnSubPath.TreeNode(-5);
        MaxPathSumOnSubPath.TreeNode e = new MaxPathSumOnSubPath.TreeNode(10);
        MaxPathSumOnSubPath.TreeNode f = new MaxPathSumOnSubPath.TreeNode(4);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(test.maxPathSumOnSubPath(root));
    }
}

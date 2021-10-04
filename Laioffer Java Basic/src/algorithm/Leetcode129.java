public class Leetcode129 {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode (int val) {
            this.val = val;
        }
    }
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] totalSum = new int[1];
        helper(root, 0, totalSum);
        return totalSum[0];
    }

    private void helper(TreeNode root, int currentSum, int[] totalSum) {
        if (root == null) {
            return;
        } else {
            currentSum = 10 * currentSum + root.val;
            if (root.left == null && root.right == null) {
                totalSum[0] += currentSum;
            }
            helper(root.left, currentSum, totalSum);
            helper(root.right, currentSum, totalSum);
        }
    }
}

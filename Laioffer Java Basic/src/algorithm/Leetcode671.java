public class Leetcode671 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int findSecond(TreeNode root) {
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;

        if (left == root.val) {
            findSecond(root.left);
        }
        if (right == root.val) {
            findSecond(root.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left == -1) {
            return right;
        } else {
            return left;
        }
    }
}

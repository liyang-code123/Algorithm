public class ClosestBinarySearchTree {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        if (a == target) {
            return a;
        }
        TreeNode child = a < target ? root.right : root.left;
        if (child == null) {
            return a;
        }
        int b = closestValue(child, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
}

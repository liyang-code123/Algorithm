package algorithm;

//LaiCode 139
public class MaxPathSumFromAnyToAny {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    public int maxPathSumFromAnyToAny (TreeNode root) {
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
        int sum = leftSum + rightSum + root.val;
        res[0] = Math.max(res[0], sum);
        return Math.max(0, Math.max(leftSum, rightSum) + root.val);
    }

    public static void main (String[] args) {
        MaxPathSumFromAnyToAny test = new MaxPathSumFromAnyToAny();
        MaxPathSumFromAnyToAny.TreeNode root = new MaxPathSumFromAnyToAny.TreeNode(-3);
        MaxPathSumFromAnyToAny.TreeNode a = new MaxPathSumFromAnyToAny.TreeNode(4);
        MaxPathSumFromAnyToAny.TreeNode b = new MaxPathSumFromAnyToAny.TreeNode(-3);
        MaxPathSumFromAnyToAny.TreeNode c = new MaxPathSumFromAnyToAny.TreeNode(2);
        MaxPathSumFromAnyToAny.TreeNode d = new MaxPathSumFromAnyToAny.TreeNode(-5);
        MaxPathSumFromAnyToAny.TreeNode e = new MaxPathSumFromAnyToAny.TreeNode(10);
        MaxPathSumFromAnyToAny.TreeNode f = new MaxPathSumFromAnyToAny.TreeNode(4);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        System.out.println(test.maxPathSumFromAnyToAny(root));
    }
}

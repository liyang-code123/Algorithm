package algorithm2;

// LaiCode 126
public class LowestCommonAncestor {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == root || b == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, a, b);
        TreeNode right = lowestCommonAncestor(root.right, a, b);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
    public static void main (String[] args) {
        LowestCommonAncestor test = new LowestCommonAncestor();
        TreeNode root = new TreeNode(2);
        TreeNode a = new TreeNode (3);
        TreeNode b = new TreeNode (4);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode (5);
        TreeNode e = new TreeNode(6);
        root.left = e;
        e.right = b;
        e.left = a;
//        c.right = b;
        System.out.println(test.lowestCommonAncestor(root, a, b).value);
    }
}

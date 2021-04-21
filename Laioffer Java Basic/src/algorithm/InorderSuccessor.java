package algorithm;

public class InorderSuccessor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    // Solution 1:
//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        // corner case
//        if (root == null) {
//            return null;
//        }
//        if (root.left == null || root.right == null) {
//            return null;
//        }
//        TreeNode successor = null;
//        while (root != null) {
//            if (p.val >= root.val) {
//                root = root.right;
//            } else {
//                successor = root;
//                root = root.left;
//            }
//        }
//        return successor;
//    }

    // Solution 2:
    public TreeNode inorderSuccessor (TreeNode root, TreeNode p) {
        if (root == null) return null;

        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != p) {
            if (cur.val < p.val) {
                cur = cur.right;
            } else if (cur.val > p.val) {
                parent = cur;
                cur = cur.left;
            }
        }
        if (cur.right != null) {
            TreeNode res = cur.right;
            while (res.left != null) {
                res = res.left;
            }
            return res;
        }
        return parent;
    }
}

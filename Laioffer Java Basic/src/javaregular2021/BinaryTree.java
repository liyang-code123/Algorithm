package javaregular2021;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.val != b.val) {
            return false;
        }
        return helper(a.left, b.right) && helper(a.right, b.left);
    }

    public boolean isTweakedTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return tweaked(root.left, root.right);
    }

    private boolean tweaked(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.val != b.val) {
            return false;
        }
        return tweaked(a.left, b.right) && tweaked(a.right, b.left) || tweaked(a.left, b.left) && tweaked(a.right, b.right);
    }

    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isBST(TreeNode root, int max, int min) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isBST(root.left, root.val, min) && isBST(root.right, max, root.val);
    }

    public List<Integer> nodesInRange(TreeNode root, int k1, int k2) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        nodesInRange(root, k1, k2, res);
        return res;
    }

    private void nodesInRange(TreeNode root, int k1, int k2, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.val > k2) {
            nodesInRange(root.left, k1, k2);
        }

        if (root.val >= k1 && root.val <= k2) {
            res.add(root.val);
        }

        if (root.val < k1) {
            nodesInRange(root.right, k1, k2);
        }
    }
}

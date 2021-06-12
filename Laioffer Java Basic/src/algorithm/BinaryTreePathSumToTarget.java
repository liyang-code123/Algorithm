package algorithm2;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSumToTarget {
    class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode(int key) {
            this.key = key;
        }
    }
    public boolean exist(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        List<TreeNode> path = new ArrayList<>();
        return helper(root, sum, path);
    }

    private boolean helper(TreeNode root, int sum, List<TreeNode> path) {
        path.add(root);
        int tmp = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            tmp += path.get(i).key;
            if (tmp == sum) return true;
        }
        if (root.left != null && helper(root.left, sum, path)) {
            return true;
        }
        if (root.right != null && helper(root.right, sum, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}

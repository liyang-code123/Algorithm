// LeetCode 652

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if(root == null || root.left == null && root.right == null) {
            return res;
        }

        postOrder(root, new HashMap<>(), res);
        return res;
    }

    private String postOrder(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if(root == null) {
            return "#";
        }
        String serial = postOrder(root.left, map, res) + "," + postOrder(root.right, map, res) + "," + root.val;
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if(map.get(serial) == 2) {
            res.add(root);
        }
        return serial;
    }
}

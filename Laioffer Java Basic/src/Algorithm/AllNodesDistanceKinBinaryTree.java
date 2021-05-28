package algorithm2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LEETCODE 863
public class AllNodesDistanceKinBinaryTree {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // corner case
        List<Integer> res = new ArrayList<>();
        if (root == null || K < 0) return res;
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }

    // find the target node and store the distance in that path that we could use it later.
    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0 ) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private void dfs(TreeNode root, TreeNode target, int K, int distance, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) distance = map.get(root);
        if (distance == K) res.add(root.val);
        dfs(root.left, target, K, distance, res);
        dfs(root.right, target, K, distance, res);
    }

    public static void main(String[] args) {
        AllNodesDistanceKinBinaryTree tree1 = new AllNodesDistanceKinBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode target = new TreeNode(3);
        int K = 3;
        System.out.println(tree1.distanceK(root, target, K));
    }
}

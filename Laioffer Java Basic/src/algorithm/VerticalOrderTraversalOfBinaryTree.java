//LeetCode 987

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {
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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int[] minColumn = new int[1];
        minColumn[0] = Integer.MAX_VALUE;
        Map<Integer, PriorityQueue<int[]>> map = new HashMap<>();
        helper(root, 0, 0, map, minColumn);
        int c = minColumn[0];
        while(map.containsKey(c)) {
            PriorityQueue<int[]> pq = map.get(c);
            List<Integer> curr = new ArrayList<>();
            while(!pq.isEmpty()){
                curr.add(pq.poll()[1]);
            }
            res.add(curr);
            c++;
        }
        return res;
    }

    private void helper(TreeNode node, int row, int col, Map<Integer, PriorityQueue<int[]>> map, int[] minColumn) {
        if (node == null) {
            return;
        }
        map.putIfAbsent(col, new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        map.get(col).offer(new int[]{row, node.val});
        minColumn[0] = Math.min(minColumn[0], col);
        helper(node.left, row + 1, col - 1, map, minColumn);
        helper(node.right, row + 1, col + 1, map, minColumn);
    }
}

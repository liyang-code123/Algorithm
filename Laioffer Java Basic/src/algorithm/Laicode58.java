import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Laicode58 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int key;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public List<Integer> zigZag(TreeNode root) {
        // corner case
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        int layer = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (layer % 2 == 0) {
                    TreeNode temp = deque.pollLast();
                    result.add(temp.key);
                    if (temp.right != null) {
                        deque.offerFirst(temp.right);
                    }
                    if (temp.left != null) {
                        deque.offerFirst(temp.left);
                    }
                } else {
                    TreeNode temp = deque.pollFirst();
                    result.add(temp.key);
                    if (temp.left != null) {
                        deque.offerLast(temp.left);
                    }
                    if (temp.right != null) {
                        deque.offerLast(temp.right);
                    }
                }
            }
            layer++;
        }
        return result;
    }
}

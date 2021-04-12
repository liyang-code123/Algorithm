package algorithm;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class ReconstructTreePostorderBST {
    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        TreeNode(int value) {
            this.value = value;
        }
    }
    public TreeNode reconstruct(int[] post) {
        // corner case
        if (post == null || post.length == 0) return null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        int n = post.length - 1;
        TreeNode root = new TreeNode(post[n--]);
        stack.offer(root);
        while (n >= 0) {
            TreeNode cur = stack.peek();
            TreeNode newNode = new TreeNode(post[n--]);
            if (newNode.value > cur.value) {
                cur.right = newNode;
                stack.push(newNode);
            } else {
                cur = stack.pop();
                while (!stack.isEmpty()) {
                    if (newNode.value < cur.value && newNode.value > stack.peek().value) {
                        break;
                    }
                    cur = stack.pop();
                }
                cur.left = newNode;
                stack.push(newNode);
            }
        }
        return root;
    }

    public static void main (String[] args) {
        ReconstructTreePostorderBST res = new ReconstructTreePostorderBST();
        int[] post = new int[]{1, 2, 4, 7, 5, 10, 13, 12, 8, 3};
        System.out.println(res.reconstruct(post));
    }
}

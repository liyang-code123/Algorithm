package algorithm2;

import java.util.HashMap;
import java.util.Map;

public class ReconstructTreePreorderInorder {
    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    public TreeNode reconstruct(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int preLeft = 0;
        int preRight = preorder.length - 1;
        int inLeft = 0;
        int inRight = inorder.length - 1;
        return helper(preorder, inorder, preLeft, preRight, inLeft, inRight, map);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preLeft, int preRight,
                            int inLeft, int inRight, Map<Integer, Integer> map) {
        // base case
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);
        int leftSize = map.get(root.value) - inLeft;
        root.left = helper(preorder, inorder, preLeft + 1, preLeft + leftSize,
                            inLeft, inLeft + leftSize - 1, map);
        root.right = helper(preorder, inorder, preLeft + leftSize + 1, preRight,
                   inLeft + leftSize + 1, inRight, map);
        return root;
    }

    public static void main (String[] args) {
        ReconstructTreePreorderInorder res = new ReconstructTreePreorderInorder();
        int[] pre = new int[]{5, 3, 1, 4, 8, 11};
        int[] in = new int[]{1, 3, 4, 5, 8, 11};
        System.out.println(res.reconstruct(pre, in));
    }
}

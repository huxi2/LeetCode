package Trees;


import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    //层次遍历
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode last = root,new_last = null;
        int depth = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
                new_last = temp.left;
            }
            if (temp.right != null) {
                queue.offer(temp.right);
                new_last = temp.right;
            }
            if (temp == last) {
                depth += 1;
                last = new_last;
            }
        }
        return depth;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth2(root.left),maxDepth2(root.right))+1;
    }
}

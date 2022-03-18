package Trees;

public class IsSymmetric {

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val==root2.val && isSameTree(root1.left,root2.right) && isSameTree(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isSameTree(root.left, root.right);
    }

}

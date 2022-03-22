package Trees;

public class SortedArrayToBST {
    //创建树将中间当作根，小于根的当作左子树，大于根当作右子树
    public TreeNode createTree(int[] nums, int start, int end) {
        if (start > end || start > nums.length) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums, start, mid - 1);
        root.right = createTree(nums, mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1) return null;
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums, 0, mid - 1);
        root.right = createTree(nums, mid + 1, nums.length - 1);
        return root;
    }
}

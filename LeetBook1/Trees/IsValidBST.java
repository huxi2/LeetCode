package Trees;

import java.util.Stack;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        //中序便利
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        Integer pre_val = null;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            // 判度胺是否升序
            if(pre_val == null){
                pre_val = temp.val;
            }else if (pre_val < temp.val) {
                pre_val = temp.val;
            } else {
                return false;
            }
            //继续完成树的遍历
            temp = temp.right;

        }
        return true;
    }

}

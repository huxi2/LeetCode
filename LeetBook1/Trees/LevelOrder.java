package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        if(root == null) return res;
        List<Integer> temp = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode lastNode=root,newAdd = null;
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            temp.add(t.val);
            if (t.left != null){
                queue.offer(t.left);
                newAdd = t.left;
            }
            if (t.right != null){
                queue.offer(t.right);
                newAdd = t.right;
            }

            if( t==lastNode){
                res.add(temp);
                temp = new LinkedList<>();
                lastNode = newAdd;
            }
        }
        return res;
    }

}

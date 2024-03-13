package LC;

import java.util.ArrayList;
import java.util.List;

public class LC145二叉树后续遍历 {
    List<Integer> result=new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        result.add(root.val);
    }

}

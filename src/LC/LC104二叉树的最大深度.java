package LC;

public class LC104二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left= maxDepth(root.left);
        int right= maxDepth(root.right);
        int max=Math.max(left,right)+1;
        return max;

    }


}



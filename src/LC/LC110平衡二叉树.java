package LC;

public class LC110平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){

            return true;
        }
        if(( isBalanced(root.left)&&
                isBalanced(root.right)&&
                Math.abs(getHeight(root.left)-getHeight(root.right))<=1)){
            return true;
           }

          return false;
    }

    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
}

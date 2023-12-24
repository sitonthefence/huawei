package LC;

public class LC404 {
    public int sumOfLeftLeaves(TreeNode root) {
           if(root==null){
               return 0;
           }
           int sumLeft=0;
           if(root.left!=null&&root.left.left==null&&root.left.right==null){
            sumLeft=root.left.val;
           }else {
               sumLeft=sumOfLeftLeaves(root.left);
           }
           int sumRight=sumOfLeftLeaves(root.right);
           return sumLeft+sumRight;

    }



}

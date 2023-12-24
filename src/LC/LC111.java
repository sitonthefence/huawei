package LC;

public class LC111 {
    public int minDepth(TreeNode root) {
          if(root==null){
              return 0;
          }
          int leftMin=minDepth(root.left);
          int rightMin=minDepth(root.right);
          if(root.left==null&&root.right!=null){
              return  rightMin+1;
          }
        if(root.left!=null&&root.right==null){
            return  leftMin+1;
        }
        return  Math.min(leftMin,rightMin)+1;







    }

}

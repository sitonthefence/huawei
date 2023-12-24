package LC;

public class LC101 {
    public boolean isSymmetric(TreeNode root) {
       return compare(root.left,root.right);
    }

    boolean compare(TreeNode left,TreeNode right){
        if(left==null&&right!=null){
            return false;
        }
        if(left!=null&&right==null){
            return  false;
        }
        if(left==null&&right==null){
            return true;
        }
        if(left.val!=right.val){
            return false;
        }
            boolean compare1 = compare(left.left, right.right);
            boolean compare2 = compare(left.right, right.left);
            return compare1&&compare2;

    }


}

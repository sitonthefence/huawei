package LC;

public class LC106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       if(postorder.length==0||inorder.length==0){
           return null;
       }
      return   traversal(inorder,0,inorder.length,
          postorder,0,postorder.length);
    }
    public TreeNode traversal(int[] inorder,int leftInorder,int rightInorder,
                              int[] postorder,int leftPostorder,int rightPostorder){
        //坑
       // if(postorder.length==0){
        if(rightPostorder-leftPostorder==0){
            return null;
        }
        //坑
        int val=postorder[rightPostorder-1];
        int mid=-1;
        //坑
        for (int i = leftInorder; i < rightInorder; i++) {
            if(inorder[i]==val){
                mid=i;
                break;
            }
        }
        TreeNode root=new TreeNode(val);
        if(postorder.length==1){
            return root;
        }
        //坑
        root.left=traversal(inorder,leftInorder,mid,postorder,leftPostorder,leftPostorder+mid-leftInorder);
        root.right=traversal(inorder,mid+1,rightInorder,postorder,leftPostorder+mid-leftInorder,rightPostorder-1);
        return root;
    }

}

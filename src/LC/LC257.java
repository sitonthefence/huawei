package LC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        LinkedList<Integer> paths=new LinkedList<>();

        traversal(root,result,paths);
        return result;
    }
    public void traversal(TreeNode root,List<String> result,LinkedList<Integer> paths){
            paths.offerLast(root.val);
            if(root.left==null&&root.right==null){
                StringBuilder stringBuilder=new StringBuilder();
                for (int i = 0; i < paths.size(); i++) {
                    stringBuilder.append(paths.get(i)+"->");
                }
                String substring = stringBuilder.substring(0, stringBuilder.length() - 2);
              result.add(substring);
              return;
            }
            if(root.left!=null){
                traversal(root.left,result,paths);
                paths.pollLast();
            }
        if(root.right!=null){
            traversal(root.right,result,paths);
            paths.pollLast();
        }


    }





}

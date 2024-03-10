package mianshi;

import java.util.ArrayList;
import java.util.List;

public class MS0106 {
    public String compressString(String S) {
        List<Node> list=new ArrayList<>();
        String S1 = S + " ";
        char pre = S1.charAt(0);
        int count=1;
        for (int i = 1; i <S1.length() ; i++) {
            char cur=S1.charAt(i);
            if(cur==pre){
                count++;
            }else {
                list.add(new Node(pre,count));
                pre=cur;
                count=1;
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (Node node : list) {
            stringBuilder.append(node.val).append(node.length);
        }
        String s = stringBuilder.toString();
        if(s.length()>=S.length()) return S;
        return s;
    }

   static   class Node{
        char val;
        int length;

       public Node(char val, int length) {
           this.val = val;
           this.length = length;
       }
   }
}

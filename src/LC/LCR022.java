package LC;



import java.util.HashSet;

public class LCR022 {
    static class ListNode {
        ListNode(int x) {
            val = x;
            next = null;
        }
    int val;
    ListNode next;
 }
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set=new HashSet<>();
        ListNode pos=head;
        while (pos!=null){
            if(set.contains(pos)){
                return pos;
            }
            set.add(pos);
            pos=pos.next;


        }
        return null;



    }
}

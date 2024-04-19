package LC;

import java.util.HashSet;
import java.util.Set;

public class LC141环形链表 {
     static class ListNode {
    int val;
   ListNode next;
    ListNode(int x) {
        val = x;
       next = null;
    }
  }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


}

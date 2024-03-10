package LC;

public class LC160 {
   public static class ListNode {
    int val;
   ListNode next;
     ListNode(int x) {
       val = x;
      next = null;
    }
}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode pA=headA;
       ListNode pB=headB;
       while (pA!=pB){
           pA=pA==null?headB:pA.next;
           pB=pB==null?headA:pB.next;

       }
       return pA;

    }
}

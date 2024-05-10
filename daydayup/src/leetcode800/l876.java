package leetcode800;

public class l876 {
    public ListNode middleNode(ListNode head) {

        ListNode dummy = new ListNode(-1,head);
        ListNode fast = dummy;
        ListNode slow = dummy;
//        while (fast.next!=null){
//            fast = fast.next;
//            if(fast.next!=null){
//                fast = fast.next;
//            }
//            slow = slow.next;
//        }
        while (fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }
}

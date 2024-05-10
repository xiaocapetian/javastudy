package leetcode;

public class l83 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1,head);
        ListNode cur = head;
        ListNode pre = dummy;
        if(head == null)return head;
        ListNode fast = head.next;
        while (fast!=null){
            if(fast.val==cur.val){
                pre.next = fast;
                cur = fast;
                fast = fast.next;
            }else {
                fast = fast.next;
                cur = cur.next;
                pre = pre.next;
            }
        }

        return dummy.next;
    }
}

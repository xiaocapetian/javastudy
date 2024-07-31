package leetcode800;

/**
 * 链表的中心节点
 */
public class l876 {

    public ListNode middleNode(ListNode head) {

        ListNode dummy = new ListNode(-1,head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            System.out.println("Fast is at: " + (fast != null ? fast.val : "null"));
            System.out.println("Slow is at: " + (slow != null ? slow.val : "null"));
        }
        System.out.println("====result is at: " + (slow.next != null ? slow.next.val : "null"));
        return slow.next;
    }

    public ListNode middleNodeV1(ListNode head){

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast.next!=null&&fast.next.next!=null){
            //while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        return slow;
    }
    public static void main(String[] args) {

        // 构造链表1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        // 构造链表1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);


        l876 sol = new l876();
        System.out.println("Testing on List 1 -> 2 -> 3 -> 4 -> 5");
        sol.middleNode(head1);

        System.out.println("\nTesting on List 1 -> 2 -> 3 -> 4 -> 5 -> 6");
        sol.middleNode(head2);
    }
}

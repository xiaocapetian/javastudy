package leetcode;

public class l19_1 {
    //知道思路自己写的，快慢指针，快的比慢的领先几步，算一下就行。
    /**
     * 这么妙的想法过几天又想不起来了啊!!!
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n+1; i++) {
            fast = fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;//为什么要弄个dummy节点?防止把头节点给删了啊
    }
}

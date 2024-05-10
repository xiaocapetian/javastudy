package leetcode100;

public class l141 {
    public boolean hasCycle(ListNode head) {
        //快慢指针,快的一次走2步,慢的一次走一步,要是碰上了说明有环
        ListNode fast = head;
        ListNode slow = head;
        if(fast==null||fast.next==null||fast.next.next==null){return false;}
        while (fast.next!=null&&fast.next.next!=null){

            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)return true;
        }
        return false;
    }
}

package leetcode;

public class l25 {
    //完全抄的答案
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur= head;
        while (cur != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(cur, tail);//翻转cur, tail内的
            cur = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = cur;
            tail.next = nex;
            pre = tail;
            cur = tail.next;
        }

        return dummy.next;


    }
    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;//最开始prev不是最前的,恰恰相反是最后的
        ListNode p = head;
        while (prev != tail) {//细品
            ListNode temp = p.next;
            p.next = prev;
            prev = p;
            p = temp;
        }
        return new ListNode[]{tail, head};
    }


}

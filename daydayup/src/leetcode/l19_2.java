package leetcode;

import java.util.Stack;
//栈
public class l19_2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = dummy;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }//挺有意思的方法诶,
        ListNode prev = stack.peek();
        prev.next=prev.next.next;
        return dummy.next;
    }

}

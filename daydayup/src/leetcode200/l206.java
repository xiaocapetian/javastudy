package leetcode200;

import java.util.Stack;

public class l206 {
    /*================反转链表================*/
    //老师说很重要，我虽然自己写出来了，但是非常慢！我居然用了一个栈！
    //确实很重要,l234的一步罢了
    //确实很重要,l92的一步罢了
    //确实很重要,美团前端面面题
    public ListNode reverseList(ListNode head) {

        ListNode dummy = new ListNode(-1,head);
        ListNode cur = head;
        Stack<Integer> stack = new Stack<>();
        //走到头,放进栈里
        while (cur!=null){
            stack.add(cur.val);
            cur = cur.next;
        }
        cur = head;
        //在走一次,从栈里取
        while (!stack.isEmpty()){
            cur.val = stack.pop();
            cur = cur.next;
        }
        return dummy.next;
    }

}

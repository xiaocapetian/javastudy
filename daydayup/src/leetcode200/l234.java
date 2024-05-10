package leetcode200;

public class l234 {
    //回文链表其实是三个小题,每道题都很重要,你能看出来码?

    //找到链表的中间节点
    //翻转(后一个)链表
    //比较是否相等
    public boolean isPalindrome(ListNode head) {

        ListNode mid = getMid(head);
        ListNode midLast = mid.next;
        //System.out.println(midLast.val);
        ListNode pre = fanzhuan(midLast);
        mid.next = pre;
        ListNode first = head;
//      ListNode first2 = head;
//        while (first2!=null){
//            System.out.println(first2.val);
//            first2 = first2.next;
//        }
        return isSame(first,pre);
    }

    private boolean isSame(ListNode first, ListNode midLast) {
        while (midLast!=null){
            if(first.val != midLast.val){
                return false;
            }
            first = first.next;
            midLast = midLast.next;
        }
        return true;
    }

    //找到链表的中间节点
    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //翻转链表
    private ListNode fanzhuan(ListNode cur){
        ListNode pre = null;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;

    }



}

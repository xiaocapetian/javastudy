package leetcode;

/**
 * 不如答案v1简单
 */
public class l86 {
    public ListNode partition(ListNode head, int x) {

        ListNode dummy = new ListNode(-1,head);
        ListNode cur = head;
        ListNode pre = dummy;
        if(cur==null){//[易错1]单独判断
            return null;
        }
        while(cur!=null&&cur.val<x){
            cur=cur.next;
            pre=pre.next;
        }
        if(cur==null){return dummy.next;}//[易错2]单独判断
        ListNode head2= cur;
        ListNode pre2= cur;
        cur=cur.next;

        while (cur!=null){
            if(cur.val<x){
                pre.next = cur;
                pre = pre.next;
                cur=cur.next;

            }else {
                pre2.next = cur;
                pre2 = pre2.next;
                cur=cur.next;

            }
        }
        pre.next = head2;
        pre2.next=null;//[易错3]这里千万不能漏了!!!!
        return dummy.next;
    }
}

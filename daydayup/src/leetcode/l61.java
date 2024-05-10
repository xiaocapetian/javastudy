package leetcode;

public class l61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = head;
        ListNode pre = dummy;
        //快比慢早前进k+1格
        int i1 = 0;
        for(;cur!=null&&i1<k;i1++){
            cur=cur.next;
        }
        if(i1==0)return head;/*[易错1]这里必须单独拿出来讨论*/
        if(cur==null){
//i是总数
            k=k%i1;cur = head;
            if(k==0)return head;/*[易错2]这里必须单独拿出来讨论*/
            for(int i = 0;cur!=null&&i<k;i++){

                cur=cur.next;
            }
        }

        ListNode slow = dummy;/*[易错]这里从dummy开始*/
        while(cur!=null){
            pre = cur;
            cur=cur.next;
            slow =slow.next;
        }
        ListNode newhead = slow.next;
        slow.next = null;
        pre.next =head;
        return newhead;
    }
}

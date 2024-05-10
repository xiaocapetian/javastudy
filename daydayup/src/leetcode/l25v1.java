package leetcode;

public class l25v1 {
    //当天晚上自己写的,磕磕绊绊
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur!=null){
            //System.out.println("pre = "+pre.val);
            ListNode fast = pre;
            for(int i = 0;i<k;i++){
                fast = fast.next;
                if(fast == null){return dummy.next;}
            }
            //System.out.println("fast = "+fast.val);

            ListNode next = fast.next;
            //System.out.println("change之前cur = "+cur.val+" next="+next.val);
            ListNode nextpre =change(cur,next,k);
            //System.out.println("change之后cur = "+cur.val+" next="+next.val);
            pre.next=fast;
            pre=nextpre;
            cur = pre.next;
            //System.out.println("下一轮之前change之前cur = "+cur.val+" pre="+pre.val);
        }
        return dummy.next;
    }
    public ListNode change(ListNode cur,ListNode next,int k){
        //ListNode[] res = new ListNode[2];
        ListNode curtemp=cur;
        ListNode prev = next;
        for(int i = 0;i<k;i++){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur =temp;
        }
        return curtemp;
    }
}

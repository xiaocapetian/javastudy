package leetcode;

public class l24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        while (cur.next!=null&&cur.next.next!=null){
            //这个写法不错,只有一个cur在动,定两个t1t2负责,下一轮就换新的
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next;
            cur.next = temp1.next;
            temp1.next = temp2.next;
            temp2.next = temp1;
            cur = temp1;//为什么是t1不是t2呀,因为t2已经放到t1后面去了
        }
        return dummy.next;
    }
    /**
     * 很久之前自己写的~
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode old = new ListNode(0,head);
        if(head == null||head.next == null){ return head;}
        ListNode dummy = head.next;
        ListNode fast = head.next.next;
        ListNode mid = head.next;
        ListNode slow = head;
        int i =0;
        do{
            if(i%2==0){
                mid.next = slow;
                slow.next= fast;
                old.next = mid;
                old = old.next;
                mid = mid.next.next;
                if(fast!=null){fast = fast.next;}
                //System.out.println(" old= "+old.val+" slow= "+slow.val+" mid= "+mid.val+" fast= "+fast.val);
            }else{
                old = old.next;
                slow = slow.next;
                mid = mid.next;
                if(fast!=null){fast = fast.next;}
            }
            i++;
        }while (mid!=null);
        return dummy;
    }
}

package leetcode300;

public class l328 {
    public ListNode oddEvenList(ListNode head) {

        ListNode d1 = new ListNode(-1,null);
        ListNode d2 = new ListNode(-1,null);
        ListNode c1 = d1;
        ListNode c2 = d2;

        ListNode cur = head;
        int num = 1;
        while (cur!=null){
            //ListNode next = cur.next;
            if(num%2==1){
                c1.next = cur;
                c1 = c1.next;
            }else {
                c2.next = cur;
                c2 = c2.next;
            }
            num++;
            cur = cur.next;

        }
        c1.next=d2.next;
        c2.next=null;//这句别忘了啊
        return d1.next;
    }
}

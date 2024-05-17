package mst;


public class m0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode c1 = l1;
        ListNode c2 = l2;


        ListNode l3 = new ListNode(-1);
        ListNode pre = l3;
        int jinwei = 0;
        while (c1!=null||c2!=null||jinwei!=0){
            int jiashu1;
            if(c1!=null){
                jiashu1 = c1.val;
                c1= c1.next;
            }else {
                jiashu1 = 0;
            }

            int jiashu2;
            if(c2!=null){
                jiashu2 = c2.val;
                c2= c2.next;
            }else {
                jiashu2 = 0;
            }

            int he = jiashu1+jiashu2+jinwei;
            jinwei = he/10;
            ListNode c3 = new ListNode();
            c3.val = he%10;
            pre.next = c3;

            pre = pre.next;
        }
        return l3.next;
    }


}


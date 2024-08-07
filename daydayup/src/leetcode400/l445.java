package leetcode400;

public class l445 {
    /**
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * @param l1 给你两个 非空 链表来代表两个非负整数。
     * @param l2  数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
     * @return 将这两数相加会返回一个新的链表。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        cur1 = fanzhuanList(cur1);
        cur2 = fanzhuanList(cur2);
        //System.out.println(print(cur1)+"   ,   "+print(cur2));
        ListNode cur = addList(cur1,cur2);
        return fanzhuanList(cur);
    }

    /**
     *
     */
    private ListNode addList(ListNode cur1,ListNode cur2) {
        /*[重难]这里如果不搞一个dummy，就很难写，有了dummy,cur就可放心的 = 往后new新子节点并移过去*/
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int jinwei=0;
        while (cur1!=null||cur2!=null||jinwei!=0){  /*[易错]这里不能缺了jinwei!!!*/
            cur.next = new ListNode(0);
            cur = cur.next;
            if(cur1!=null&&cur2!=null){
                cur.val =(cur1.val+cur2.val+jinwei)%10;
                jinwei = (cur1.val+cur2.val+jinwei)/10;
                cur1 =cur1.next;
                cur2 =cur2.next;

            }else if(cur1!=null){
                cur.val =(cur1.val+jinwei)%10;
                jinwei = (cur1.val+jinwei)/10;
                cur1 =cur1.next;

            }else if(cur2!=null){
                cur.val =(cur2.val+jinwei)%10;
                jinwei = (cur2.val+jinwei)/10;
                cur2 =cur2.next;

            }else{//说明虽然cur1和2没了，但是还有jinwei
                cur.val=jinwei;
                jinwei = 0;
            }

        }
        return dummy.next;
    }

    /**
     * 翻转链表是基础中的基础，不能忘啊
     */
    private ListNode fanzhuanList(ListNode head) {

        ListNode last = null;
        ListNode cur = head;
        if(cur==null)return null;
        ListNode pre = cur.next;
        while (pre!=null){
            cur.next = last;
            last = cur;
            cur = pre;
            pre = pre.next;
        }
        cur.next = last;
        return cur;
    }

    private int print(ListNode cur) {
        int res = 0;
        while (cur!=null){
            res =res*10+ cur.val;
            cur = cur.next;
        }
        return res;
    }
}

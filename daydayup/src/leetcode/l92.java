package leetcode;

public class l92 {
    /*============翻转链表,只是翻转链表的一部分===============*/
    //是自己写的没错,但是写的不够规范,小错很多很难改
    //思路和v1一模一样,但是v1简洁多了
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1,head);
        ListNode curpre = dummy;
        ListNode curstart = head;
        ListNode curend = head;
        int count = 1;
        while (count<right){
            curend = curend.next;
            count++;
        }
        ListNode curendNext = curend.next;
        count = 1;/*!!!!这里别忘了重置count!!!!*/
        while (count<left){
            curstart=curstart.next;
            curpre=curpre.next;
            count++;
        }
        /*curpre,curstart,...,curend,curendNext */
        //curpre.next = curend;
        //对比一下v1,直接把切断!!! 思路就清晰多了
        fanzhuan(curpre,curstart,curend);

        curpre.next = curend;
        curstart.next = curendNext;
        System.out.println("curpre= "+curpre.val);
        System.out.println("curstart= "+curstart.val);
        System.out.println("curend= "+curend.val);
        return dummy.next;/*!!这里要写dummy.next,而不是head!因为如果head就在要翻转的范围时那head就不是head了
        而这种情况下,由curpre.next = curend;(此时dummy是curpre.可以保证它指向的不在是head
        */
    }

    private void fanzhuan(ListNode curpre,ListNode curstart, ListNode curend) {
        ListNode cur = curstart;
        ListNode pre = curpre;
        while (pre!=curend){//注意为了最后一位也能够翻转,要写pre!=curend,而不是cur!=curend
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
    }

}

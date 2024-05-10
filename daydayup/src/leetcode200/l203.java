package leetcode200;



public class l203 {
    /**虚拟一个dummy头节点
     * pre指针和cur指针一起!!!
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        //if(head==null){return null;}
        //我的思路没问题
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;//但是还要加一个pre
        ListNode cur = head;
        while(cur!=null){
            if(cur.val==val){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }

        }
        return dummy.next;
    }

    /**
     * 方案二,自己写的错误版本改造
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {

        if(head==null){return null;}
        ListNode headd = new ListNode(0,head);
        ListNode cur = headd;

        while(cur!=null){
            while(cur.next!=null&&cur.next.val==val){//这个得写while,,,
                cur.next = cur.next.next;
            }
            //if(cur.val!=val){}
            cur = cur.next;
        }
        return headd.next;
    }

    /**
     * 自己写的错误版本!
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements_old(ListNode head, int val) {

        if(head==null){return null;}
        ListNode headd = new ListNode(0,head);
        ListNode cur = headd;
        while(cur!=null&&cur.next!=null){//必须加这个我能理解cur!=null
            if(cur.next.val==val){
                cur.next = cur.next.next;
            }
            //if(cur.val!=val){}
            cur = cur.next;//不能这样子写，你看这样下一回又判断cur.next了，cur指的指就被跳过了
            //所以上一个不能写if要写while
        }
        return headd.next;
    }
}

package leetcode100;

/**
 * 难点:拆分成三步:
 * 1.寻找中点
 * 2.链表反转
 * 3.两链表交错合并
 */
public class l143 {
    public void reorderList(ListNode head) {
        //第一步,找中间节点
        ListNode dummy = new ListNode(-1,head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next!=null){
            fast = fast.next;
            if(fast.next!=null){
                fast = fast.next;
            }
            //fast = fast.next.next;
            slow = slow.next;
        }

        ListNode h2 = slow.next;
        //切断
        slow.next = null;
        //System.out.println(h2.val);
        //第二步,倒转
        ListNode head2 = daozhuan(h2);
        //print(head);
        //print(head2);
        //第三步合并
        combine(head,head2);

    }

    private void combine(ListNode head, ListNode head2) {
        ListNode cur = head;
        ListNode cur2 = head2;
        while (cur2!=null){
            ListNode temp = cur.next;
            ListNode temp2 = cur2.next;
            cur.next = cur2;
            cur2.next = temp;
            cur = temp;
            cur2 = temp2;
        }
    }

    /**
     * 链表翻转
     * @param head
     * @return
     */
    public ListNode daozhuan(ListNode head) {
        if(head ==null)return null;
        ListNode cur = head.next;
        head.next = null;
        ListNode pre = head;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;/*[易错]这两句顺序不能写反啊!!!*/
        }
        return pre;
        
    }

    private void print(ListNode head){
        while (head!=null){
            System.out.print(head.val+",");
            head=head.next;
        }
    }
}

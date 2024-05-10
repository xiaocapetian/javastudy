package leetcode;

/**
 * [易错]while (cur!=null&&cur.next!=null){ 这里必须写上cur!=null
 * 因为在下面的循环可能使cur指向最后的null(想象一下dummy->1->1->null)
 */
public class l82 {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur = head;
        //if(cur==null)return null;
        while (cur!=null&&cur.next!=null){
            while (cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next!=cur){
                pre.next = cur.next;
                cur=cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 官解答案一个一个删的
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/solutions/678122/shan-chu-pai-xu-lian-biao-zhong-de-zhong-oayn/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}

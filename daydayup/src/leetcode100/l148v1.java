package leetcode100;
/*给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。*/
/*时间复杂度是 O(nlogn)的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n^2))，其中最适合链表的排序算法是归并排序。

[**排序链表**]
取中间值mid
归并左,归并右,
合并
* */
public class l148v1 {
    public ListNode sortList(ListNode head) {
        return guibingsort(head,null);

    }
    public ListNode guibingsort(ListNode head,ListNode tail){
        System.out.println("ddd"+getlen(head,tail));
        if(getlen(head,tail)==0){return null;}
        else if(getlen(head,tail)==1){return head;}

        ListNode mid = getMid(head,tail);
        ListNode qian = guibingsort(head,mid);
        ListNode hou = guibingsort(mid,tail);
        //现在qian和hou都是一个节点了(看成未来升序的链表,问题转化为l21题,合并两个升序的链表
        ListNode res = merge(qian,hou);
        return res;
    }

    private ListNode merge(ListNode qian, ListNode hou) {
        if(qian == null)return hou;
        else if(hou == null)return qian;
        else if(qian.val< hou.val){
            //return merge(qian.next,hou);
            qian.next = merge(qian.next,hou);
            return qian;
        }
        else {
            hou.next = merge(qian,hou.next);
            return hou;
        }
    }

    public ListNode getMid(ListNode head,ListNode tail){
        ListNode fast = head;
        ListNode slow = head;
        if(fast==tail)return fast;
        while (fast.next!=tail&&fast.next.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;//这里必须写slow.next要么就用法二
    }
    public ListNode getMid2(ListNode head,ListNode tail) {
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        return slow;
    }
    public int getlen(ListNode head,ListNode tail){
        int count =0;
        while (head!=tail){
            head=head.next;
            count++;
        }
        return count;
    }


}

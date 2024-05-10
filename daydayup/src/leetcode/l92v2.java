package leetcode;


public class l92v2 {
    //一个很有意思的思路
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        //从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        //这个很神奇啊
        /*pre这个节点是不会动的,就在反转区域前一个,
        cur相对于节点不动,但是这个反转区第一个节点一直再向后动
        * */
        for (int i = 0; i < right - left; i++) {
            //每一个循环都把next指的那一个拉到pre的后面,
            next = cur.next;//next永远指向 cur 的下一个节点,(然后把它拉到pre之后
            cur.next = next.next;//cur.next现在是next的下一个了
            next.next = pre.next;//就是让next替换掉pre.next的位置啊
            pre.next = next;
        }
        return dummyNode.next;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/reverse-linked-list-ii/solutions/634701/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

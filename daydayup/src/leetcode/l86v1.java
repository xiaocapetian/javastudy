package leetcode;

/**
 * 瞧瞧人家写的多简洁
 */
public class l86v1 {
    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;


    }
}
//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/partition-list/solutions/543768/fen-ge-lian-biao-by-leetcode-solution-7ade/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
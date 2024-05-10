package leetcode;

public class l19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
//自己想的，但是要记住几点，首先，不能从head开始，要提前一步自建一个，防止删完了
        //而且这样非常慢，不符合要求
        ListNode dummy = new ListNode(0,head);
        ListNode thead = head;
        int size = 1;
        while(thead.next!=null){
            thead = thead.next;
            size++;
        }
        System.out.println("size"+size);
        thead = head;
        ListNode cur = dummy;//其次这里必须从上一个开始遍历，别问为什么，问就是报错<===现在知道了.为什么要弄个dummy节点?防止把头节点给删了啊
        for (int i = 1; i < size - n+1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}

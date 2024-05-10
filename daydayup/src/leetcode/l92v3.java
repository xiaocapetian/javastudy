package leetcode;

public class l92v3 {
    //太炫技了,还是学v1和v2
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left==1){return reverse(head,right);}
        head.next = reverseBetween(head.next,left-1,right-1);//这个写法有点炫技了
        return head;
    }
    ListNode successor = null; // 后驱节点
    private ListNode reverse(ListNode head,int right){
        if(right==1){
            successor = head.next;//只再这一步定下后驱节点之后的
            return head;}
        ListNode last = reverse(head.next,right-1);
        //ListNode successor = head.next.next;
        head.next.next = head;
        head.next = successor;
        return last;
    }
}

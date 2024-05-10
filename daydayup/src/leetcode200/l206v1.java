package leetcode200;

public class l206v1 {
    //双指针法
    public ListNode reverseList(ListNode head) {
        //ListNode dummy = new ListNode(-1,head);
        ListNode pre = null;//!!!不能写ListNode pre= dummy了！！最后一位一定要指向空！
        ListNode cur = head;

        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //递归法  很难思考啊!
    public ListNode reverseList2(ListNode head) {
        return reverse(head,null);
    }
    ListNode reverse(ListNode cur,ListNode pre){
        //什么时候结束递归，返回？看上面，//但是你不能光看上面啊,直接写的时候哪有上面给你看?
        if(cur==null)return pre;/*这个是时候返回的"head"其实是最后一个节点,之后层层返回,头节点就这么来了*/
        //循环中做什么？看上面
        /*cur指向pre*/
        ListNode temp = cur.next;
        cur.next = pre;
        //移动指针的部分递归写
        return reverse(temp,cur);//这里这个return 递归函数的操作很值得思考

    }

    //递归法
    //怎么理解?想像一下这是一个有点"前序"感觉的样子
    ListNode reverse(ListNode head) {
        if (head.next == null) return head;//这里返回了"head"其实是最后一个节点,之后层层返回,头节点就这么来了
        ListNode last = reverse(head.next);//你看啊,在这里递归的
        //那么假设我们成功了,也就是head.next的之后全都成功反转了
        //0->0<-0<-0<-0
        //现在要做什么呀?
        head.next.next = head;
        head.next = null;
        return last;//返回的是什么,你能返回head吗?不能,你应该返回新的头节点,怎么得到呢?递归函数的返回值来
    }
//    作者：labuladong
//    链接：https://leetcode.cn/problems/reverse-linked-list-ii/solutions/37247/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

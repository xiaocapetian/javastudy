package leetcode100;

public class l160v2 {
    /**
     * 二刷  不像V2写的那么简洁，但是也可以了
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1!=null&&cur2!=null){
            cur1 = cur1.next; cur2 = cur2.next;
        }
        if(cur1==null){
            cur1 = headB;
            while(cur2!=null){
                cur1 = cur1.next; cur2 = cur2.next;
            }
            cur2 = headA;
            while(cur1!=null&&cur2!=null){
                if(cur1==cur2)return cur1;/*[易错]*/ //这里这里这个要放在前面,不让碰上2个都是一个相同节点的情况就会错
                cur1 = cur1.next; cur2 = cur2.next;
                //if(cur1==cur2)return cur1;
            }
            return null;
        }else{
            return getIntersectionNode(headB,headA);
        }
    }
}

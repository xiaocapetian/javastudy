package leetcode100;

public class l160 {
    /**
     * 这个写法是真的简洁
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode you = headA;
        ListNode she = headB;

        while(you!=she){
            you = you!=null ? you.next : headB; // 当你走到终点时，开始走她走过的路
            she = she!=null ? she.next : headA; // 当她走到终点时，开始走你走过的路

        }
        //走完两轮的时候都如果没连上,说明会在null连上
        return you;
    }

    //flag完全赘余
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode you = headA;
        ListNode she = headB;
        int flag = 0;
        while(you!=she&&flag<3){
            if(you==null){
                you =headB;flag++;}
            else {
                you =you.next;
            }

            if(she==null){
                she =headA;flag++;}
            else {
                she =she.next;
            }

        }
        if(flag==3){return null;}else {
            return you;
        }
    }

}

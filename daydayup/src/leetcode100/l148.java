package leetcode100;

public class l148 {
    public ListNode sortList(ListNode head) {
//冒泡排序是对的，但是超时了
        int len = 0;
        ListNode cur =head;
        while (cur!=null){
            cur=cur.next;
            len++;
        }
        if(len<2){return head;}
        cur =head.next;
        ListNode pre = head;
        for(int i =1;i<len;i++){
            int count=0;
            ListNode curr =cur;
            ListNode pree = pre;
            while (count<len-i){
                if(pree.val>curr.val){
                    int temp = pree.val;
                    pree.val=curr.val;
                    curr.val = temp;
                }
                //System.out.println(curr.val+",");
                curr = curr.next;
                pree = pree.next;
                count++;
            }

        }
        return head;
    }
}

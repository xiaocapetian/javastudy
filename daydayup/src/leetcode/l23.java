package leetcode;

public class l23 {
    //自己写的太慢
    public ListNode mergeKLists(ListNode[] lists) {
        //if(lists.length==1)return lists[0];
        if(lists.length==0)return null;
        for(int i = 1;i<lists.length;i++){
            lists[0] = combine(lists[0],lists[i]);
        }
        return lists[0];
    }

    private ListNode combine(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        else if(l2==null)return l1;
        else if(l1.val<l2.val){
            l1.next = combine(l1.next,l2);
            return l1;
        }else {
            l2.next = combine(l2.next,l1);
            return l2;
        }
    }
}

package leetcode;

public class l23v1 {
    //两两合并
    public ListNode mergeKLists(ListNode[] lists) {
        //if(lists.length==1)return lists[0];
        if(lists.length==0)return null;

        return merge(lists,0 ,lists.length-1);

    }
    private ListNode merge(ListNode[] lists, int lo ,int hi) {
        if(lo==hi){return lists[lo];}
        int mid = (lo+hi)/2;

        ListNode l1 = merge(lists,lo ,mid);
        ListNode l2 = merge(lists,mid+1 ,hi);
        return combine(l1,l2);
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

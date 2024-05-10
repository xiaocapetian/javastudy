package leetcode;

public class l21 {
    //完全自己想出来的
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode newlist = new ListNode(0,list1);
        ListNode l3 = newlist;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            }else {
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            }

        }
        if(l1!=null){l3.next = l1;}
        if(l2!=null){l3.next = l2;}
        return newlist.next;
    }
    //递归法这也太巧妙了,有点像二叉树诶
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    //迭代法
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }



}

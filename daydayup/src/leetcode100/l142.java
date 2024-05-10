package leetcode100;

public class l142 {
    public ListNode detectCycle(ListNode head) {
        //快慢指针,快的一次走2步,慢的一次走一步
        ListNode fast = head;
        ListNode slow = head;
        if(fast==null||fast.next==null||fast.next.next==null){return null;}

        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast.equals(slow)){
                //break;//不用break,接着就在这写
                ListNode countNode =head;
                while (countNode!=slow){
                    countNode = countNode.next;
                    slow = slow.next;

                }
                return countNode;

            }

        }
        return null;
        //if(fast.next==null||fast.next.next==null)return null;
        //下面是数学推到过程,过程看随想,
        //2*(x+y)=x+y+n(x+y)   (n>=1)
        // 结论x=(n-1)(y+z)+z
        //太神奇了谁能想的到!    y+z是完整的一圈,那在快慢相遇的时刻,再出发一个3号指针,3号和慢相遇的地方就是目标啦
        /*
 */
    }
}

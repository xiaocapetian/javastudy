package leetcode100;

public class l109 {
    public TreeNode sortedListToBST(ListNode head) {

        return buildTree(head);
    }
    public TreeNode buildTree(ListNode head){
        if(head==null)return null;
        ListNode mid= GetMidListNode(head);
        ListNode left;
        //TreeNode cur = new TreeNode(mid.val,null,null);
        //如果就剩1个,会把左右设置成null
        //如果剩2个, 1 2 左就是1 右就是null
        if(mid == head){
            left = null;
            //return new TreeNode(mid.val,null,null);
        }else {
            left = head;
        }
        ListNode right = mid.next;
        TreeNode cur = new TreeNode(mid.val,buildTree(left),buildTree(right));
        return cur;
    }

    /**
     * 取得链表的中间节点,
     */
    public ListNode GetMidListNode(ListNode head){

        ListNode slow = head;
        ListNode fast = head;
        //注意如果这里写成ListNode pre = head;  那有风险,那必须写成 while (fast!=null&&fast.next!=null){才能对,详细4种情况看下文
        ListNode pre = null;
        //ListNode pre = head;
        /*[重难易错] 这里不可以成head*/
        //假设此时链表是 -10,-3, 若采取while (fast.next!=null&&fast.next.next!=null){写法
        // 结果会是 : 左是空,中是-10,右是3 就会错把10的next置空)

        /*[重难]取链表中心节点怎么取*/
        //如果是偶数个节点,123456  上一行要的是前一个3,下一行要的是后一个4 在本题都可以,但是要注意上面的写法!!!
        //while (fast.next!=null&&fast.next.next!=null){
        while (fast!=null&&fast.next!=null){

            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        //pre.next = null;
        System.out.println("head"+head.val+"开头的链表中间节点是"+slow.val+"我现在把pre"+pre.val+"的next置空了");
        return slow;
    }

}
//[-10,-3,0,5,9]
/*
 *ListNode pre = head;
  while (fast!=null&&fast.next!=null){
head-10开头的链表中间节点是0我现在把pre-3的next置空了
head-10开头的链表中间节点是-3我现在把pre-10的next置空了
head-10开头的链表中间节点是-10我现在把pre-10的next置空了
head5开头的链表中间节点是9我现在把pre5的next置空了
head5开头的链表中间节点是5我现在把pre5的next置空了
 */
/*
 *ListNode pre = head;
  while (fast.next!=null&&fast.next.next!=null){
  *
head-10开头的链表中间节点是0我现在把pre-3的next置空了
head-10开头的链表中间节点是-10我现在把pre-10的next置空了(问题就出在这了,此时链表是 -10,-3, 我现在这里左是空,中是-10,右是3 这里错把10的next置空)
head5开头的链表中间节点是5我现在把pre5的next置空了
 */
/*
ListNode pre = null;
while (fast.next!=null&&fast.next.next!=null){
 *
 * head-10开头的链表中间节点是0我现在把pre-3的next置空了
head-10开头的链表中间节点是-10pre现在就是空
head-3开头的链表中间节点是-3pre现在就是空
head5开头的链表中间节点是5pre现在就是空
head9开头的链表中间节点是9pre现在就是空
 */
/*
        ListNode pre = null;
        while (fast!=null&&fast.next!=null){
head-10开头的链表中间节点是0我现在把pre-3的next置空了
head-10开头的链表中间节点是-3我现在把pre-10的next置空了
head-10开头的链表中间节点是-10pre现在就是空
head5开头的链表中间节点是9我现在把pre5的next置空了
head5开头的链表中间节点是5pre现在就是空
 */
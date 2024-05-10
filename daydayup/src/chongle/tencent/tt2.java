package chongle.tencent;

public class tt2 {
    public boolean[] canSorted (ListNode[] lists) {
        // write code here
        boolean[] res = new boolean[lists.length];
        for (int i = 0; i < lists.length; i++) {
            boolean flag;
            ListNode cur = lists[i];

            if(ifzeng(cur)){
                res[i] = true;
            }
        }
        return res;
    }
    public boolean ifzeng(ListNode cur){
        int first = cur.val;
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = cur;
        while (cur!=null){
            while (cur!=null&&pre.val<cur.val){
                cur = cur.next;
                pre = pre.next;
            }
            if(cur==null){//说明已经是全递增的了
                //res[i] = true;
                //break;
                return true;
            }else {
                cur = cur.next;
                pre = pre.next;
                while (cur!=null){
                    if(pre.val>=cur.val){return false;}
                    else {
                        if (cur.val > first) {
                            //res[i] = false;
                            //break;
                            return false;
                        }
                        cur = cur.next;
                        pre = pre.next;
                    }
                }
                return true;
            }
        }
        return true;
    }
    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
}


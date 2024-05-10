package leetcode;


class leetcode_2 {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        //ListNode l3 = null;
        ListNode l3 = new ListNode(0,null);
        ListNode l4 = l3;
        while(l1 != null || l2 != null){

            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            //System.out.print(n1+"and"+n2);
            int sum = n1 + n2 + carry;
            carry = 0;
            if(sum>9){
                carry = 1;
                sum = sum - 10;
            }
            l4.val = sum;
            if(l1 != null){l1 = l1.next;}
            if(l2 != null){l2 = l2.next;}
            if(l1 != null||l2 != null){l4.next = new ListNode();l4 = l4.next;}
            else if(l1 == null&&l2 == null&&carry ==1){l4.next = new ListNode(1);l4 = l4.next;}

        }
        return l3;

    }
    }




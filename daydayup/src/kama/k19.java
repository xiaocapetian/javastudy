package kama;

import java.util.Scanner;

class k19{
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            ListNode head = new ListNode(-1,null);
            ListNode last = head;
            for(int i = 0;i<n;i++){
                ListNode listNode = new ListNode(sc.nextInt(),null);
                last.next = listNode;
                last = listNode;
            }
            fan(head);
        }

    }
    public static void fan(ListNode head){
        //System.out.println("fan");
        ListNode cur = head.next;
        if(cur==null){System.out.println("list is empty");return;}

        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
        ListNode last = null;
        cur = head.next;
        //head.next = null;
        while(cur!=null){
            //System.out.print(cur.val+" ");
            ListNode fast = cur.next;
            cur.next = last;
            last =cur;
            cur = fast;
        }
        cur = last;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();

    }
}
package kama;

import java.util.Scanner;

public class k20 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n= sc.nextInt();
            ListNode head = new ListNode(-1,null);
            ListNode last=head;
            for(int i = 0;i<n;i++){
                ListNode newListNode = new ListNode(sc.nextInt(),null);
                last.next=newListNode;
                last = newListNode;
            }
            delete(head);
        }
    }
    public static void delete(ListNode head){
        ListNode cur = head.next;
        if(cur==null){System.out.println("list is empty");return;}
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();

        ListNode last = head;
        cur = head.next;
        while(cur.next!=null){
            if(cur.val==cur.next.val){
                last.next = cur.next;
                cur = cur.next;
            }else{
                last = cur;
                cur = cur.next;
            }

        }
        //
        cur = head.next;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}

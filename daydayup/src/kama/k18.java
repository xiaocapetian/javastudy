package kama;

import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class k18 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            ListNode lastListNode = new ListNode(sc.nextInt(),null) ;
            for(int i = 1;i<n;i++){
                //System.out.print("add");
                ListNode nowListNode = new ListNode(sc.nextInt(),lastListNode) ;
                lastListNode = nowListNode;
            }
            ListNode head =  new ListNode(-1,lastListNode);
            sc.nextLine();
            int m = Integer.parseInt(sc.nextLine());
            for(int i = 0;i<m;i++){
                String str = sc.nextLine();
                if(str.split(" ")[0].equals("show")){
                    show(head);
                }else if(str.split(" ")[0].equals("delete")){
                    int item = Integer.parseInt(str.split(" ")[1]);
                    delete(head,item-1);
                }else if(str.split(" ")[0].equals("get")){
                    int item = Integer.parseInt(str.split(" ")[1]);
                    get(head,item-1);
                }
                else if(str.split(" ")[0].equals("insert")){
                    int item = Integer.parseInt(str.split(" ")[1]);
                    int num = Integer.parseInt(str.split(" ")[2]);
                    insert(head,item-1,num);
                }


            }

        }
    }
    public static void insert(ListNode head,int item,int num){
        ListNode cur = head.next;
        ListNode last = head;
        for(int i = 0;i<item;i++){
            if(cur==null){System.out.println("insert fail");return;}
            last = cur;
            cur=cur.next;
        }
        ListNode newListNode = new ListNode(num,cur) ;

        last.next = newListNode;
        System.out.println("insert OK");
    }
    public static void delete(ListNode head,int item){
        ListNode cur = head.next;
        ListNode last = head;
        for(int i = 0;i<item;i++){
            if(cur==null){System.out.println("delete fail");return;}
            last = cur;
            cur=cur.next;
        }
        last.next = cur.next;
        System.out.println("delete OK");
    }
    public static void get(ListNode head,int item){
        //System.out.println("get");
        ListNode cur = head.next;
        for(int i = 0;i<item;i++){
            if(cur==null){System.out.println("get fail");return;}
            cur=cur.next;
        }
        System.out.println(cur.val);
    }
    public static void show(ListNode head){
        //System.out.print("show");
        ListNode cur = head.next;
        if(cur==null){System.out.println("Link list is empty");return;}
        while(cur!=null){
            //System.out.print("show");
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }

}

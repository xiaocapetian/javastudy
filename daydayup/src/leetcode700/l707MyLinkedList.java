package leetcode700;
public class l707MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        int index = 1;

        obj.addAtHead(7);
        obj.addAtHead(2);
        obj.addAtHead(1);
        obj.print();
        System.out.println();
        obj.addAtIndex(3,0);
        obj.print();
        System.out.println();
        obj.deleteAtIndex(2);
        obj.addAtHead(6);
        obj.addAtTail(4);
        obj.print();
        System.out.println(obj.get(4));
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val=val;
    }
}
class MyLinkedList {
    int size;
    ListNode dummyHead;
    public MyLinkedList() {
        this.size=0;
        dummyHead =new ListNode();
    }

    public int get(int index) {
        if(index<0||index>=size)return -1;
        ListNode cur = dummyHead.next;
        for (int i = 0;i<index;i++){
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {

        ListNode newHead = new ListNode(val);
        newHead.next = dummyHead.next;
        dummyHead.next = newHead;
        size++;
        //this = cur;
    }

    public void addAtTail(int val) {
        ListNode newTail = new ListNode(val);
        ListNode cur = dummyHead;
        while (cur.next!=null){
            cur = cur.next;
        }
        cur.next = newTail;
        size++;
    }

    public void addAtIndex(int index, int val) {
        //在index之前加
        if(index<0||index>size)return;
        if(index==size){addAtTail(val);return;}
        ListNode newNode = new ListNode(val);
        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        for (int i = 0;i<index;i++){
            pre = cur;
            cur = cur.next;
        }
        pre.next = newNode;
        newNode.next = cur;
        size++;

    }

    public void deleteAtIndex(int index) {
        if(index<0||index>=size)return;
        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        for (int i = 0;i<index;i++){
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        size--;
    }
    public void print(){
        ListNode cur = dummyHead;
        while (cur.next!=null){
            cur = cur.next;
            System.out.print(cur.val+",");
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

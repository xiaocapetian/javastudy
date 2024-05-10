package leetcode100;

import java.util.HashMap;
//自己写的写了好久啊..
public class l146v1 {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);

        lruCache.put(1,1);
        System.out.println(lruCache.get(1));
        lruCache.put(2,3);

        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
//System.out.println(lruCache.hash);
    }


}
class LRUCache {
    private class LinkedNode{
        int val;
        int key;/*这个不能少!!!*///为什么不能少,删一个节点需要找
        LinkedNode pre;
        LinkedNode next;

        public LinkedNode() {}
        public LinkedNode(int key,int val, LinkedNode pre, LinkedNode next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
    int capacity;
    int size;
    HashMap<Integer,LinkedNode> hash = new HashMap<>();
    LinkedNode head;
    LinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
        size=0;
    }

    public int get(int key) {
        if(!hash.containsKey(key))return -1;
        LinkedNode cur = hash.get(key);
        moveToHead(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        LinkedNode cur = new LinkedNode(key,value,null,null);
       //
        if(hash.containsKey(key)){
            moveToHead(hash.get(key));
            hash.get(key).val =value;

        }else {
            hash.put(key,cur);
            if(size<capacity){
                addHeadNode(cur);
                size++;
            }else {
                LinkedNode removed = removeNode(tail.pre);
                hash.remove(removed.key);/*移除的时候传进去键而不是值*/
                //System.out.println("removed.val = "+removed.val);
                //System.out.println("hashsize"+hash.size());
                addHeadNode(cur);
            }
        }
    }
    private void moveToHead(LinkedNode cur) {
        removeNode(cur);
        addHeadNode(cur);
    }

    private void addHeadNode(LinkedNode cur) {
        cur.pre = head;
        cur.next = head.next;
        head.next.pre =cur;
        head.next = cur;
    }

    private LinkedNode removeNode(LinkedNode cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        return cur;
    }

    private void addTail(LinkedNode cur) {
        cur.pre = tail.pre;
        cur.next = tail;
        tail.pre.next =cur;
        tail.pre = cur;
    }
}
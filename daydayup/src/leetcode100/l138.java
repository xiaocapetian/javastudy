package leetcode100;

import java.util.HashMap;

public class l138 {

    public Node copyRandomList(Node head) {
        Node cur = head;
        Node newdummy = new Node(-1);
        Node newpre = newdummy;
        HashMap<Node,Node> hash = new HashMap<>();

        while (cur!=null){
            Node newcur;
            if(hash.containsKey(cur)){
                newcur = hash.get(cur);
            }else {
                newcur = new Node(cur.val);
                hash.put(cur,newcur);
            }

            //Node newcur = new Node(cur.val);
            newpre.next = newcur;
            if(cur.random!=null){
                if(hash.containsKey(cur.random)){
                    newcur.random= hash.get(cur.random);
                }
                else {
                    newcur.random=new Node(cur.random.val);
                    hash.put(cur.random,newcur.random);
                }
            }

            newpre = newcur;
            cur = cur.next;
        }

        return newdummy.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
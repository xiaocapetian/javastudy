package leetcode200;
//瞅了一眼答案的思路后一遍过诶!
public class l208 {

}
class Trie {
    class TireNode{
        //char val;
        boolean finished;
        TireNode[] next;
        TireNode(){
            this.next = new TireNode[26];
        }

    }
    TireNode head;
    public Trie() {
        head = new TireNode();
    }

    public void insert(String word) {
        char[] words = word.toCharArray();
        TireNode cur = head;
        for (char c : words) {
            if(cur.next[c-'a']!=null){

            }else {
                cur.next[c-'a'] = new TireNode();
            }
            cur = cur.next[c-'a'];
        }
        cur.finished = true;
    }

    public boolean search(String word) {
        char[] words = word.toCharArray();
        TireNode cur = head;
        for (char c : words) {
            if(cur.next[c-'a']!=null){
                cur = cur.next[c-'a'];
            }else {
                return false;
            }

        }
        return cur.finished;
    }

    public boolean startsWith(String prefix) {
        char[] words = prefix.toCharArray();
        TireNode cur = head;
        for (char c : words) {
            if(cur.next[c-'a']!=null){
                cur = cur.next[c-'a'];
            }else {
                return false;
            }

        }
        return true;
    }
}

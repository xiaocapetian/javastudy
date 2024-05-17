package leetcode400;
//lcr155

/**
 * 自己写出来的哦,我棒棒!
 */
public class l426 {
    public Node treeToDoublyList(Node root) {
        if(root==null)return null;
        //左中右
        Node[] nodes = find(root);
        nodes[0].left = nodes[1];
        nodes[1].right = nodes[0];

        return nodes[0];
    }

    private Node[] find(Node cur) {
        Node[] arr = new Node[2];
        if(cur.left==null){
            //如果没有左儿子了,自己就是以自己为父节点的所有节点的最左,把设成自己
            arr[0] = cur;
        }else {
            Node[] nodes = find(cur.left);
            //我的左应该由我的左儿子告诉我
            //我自己的左是我左儿子的最右,我要告诉爸爸的左是我做儿子的最左,
            //此外我还要负责包办我做儿子的最右它的右就是我
            cur.left = nodes[1];
            nodes[1].right = cur;
            arr[0] = nodes[0];
        }
        if(cur.right==null){
            arr[1] = cur;
        }else {
            Node[] nodes = find(cur.right);
            cur.right = nodes[0];
            nodes[0].left=cur;/*[易错]这里不能漏啊!*/
            arr[1] = nodes[1];
        }
        return arr;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

}

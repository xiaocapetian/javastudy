package leetcode100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 我还挺秀啊一次写出来
 */
public class l133 {


    HashMap<Integer, Node> hash = new HashMap<>();/*[易错]这里键值要这样*/
    int[] visited = new int[101];
    public Node cloneGraph(Node node) {

        return  colne(node);
    }

    private Node colne(Node node) {
        if(node==null){return null;}
        if(visited[node.val]==1){//如果访问过了(已经克隆过了),那肯定在map里啊,
            return hash.get(node.val);}/*[易错]这里我能返回null吗,不可以,得返回存在hash的值*/
        Node newnode;
        visited[node.val]=1;//现在访问了
        if(hash.containsKey(node.val)){//如果已经克隆了,取出来
            newnode=hash.get(node.val);
        }else {//如果没克隆过,那就new克隆
            newnode = new Node(node.val);
            hash.put(node.val,newnode);
        }
        for (Node neighbor : node.neighbors) {
            newnode.neighbors.add(colne(neighbor));
        }

        return newnode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

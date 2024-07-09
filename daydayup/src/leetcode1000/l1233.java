package leetcode1000;

import java.util.*;

/**,我自己想的方法,很复杂 直接被v1全方位吊打好吧
 *
 * 易错+重难,这里必须回溯
 */
public class l1233 {
    /**
     * 删除子文件夹
     * @param folder 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
     * @return 输出：["/a","/c/d","/c/f"]
     */
    public List<String> removeSubfolders(String[] folder) {

        Node gen = new Node("");
        //Set<Node> gen = new HashSet<>();
        for (String s : folder) {

            String[] fol = s.split("/");
            System.out.println(Arrays.toString(fol));
            if (fol.length == 0) continue;
            find(fol,1,gen);
        }
        List<String> res = new ArrayList<>();
        dfs(gen,res,new StringBuilder());
        return res;
    }

    private void dfs(Node cur,List<String> res,StringBuilder path) {
        //int len = path.length();
        //path.append("/"+cur.name);
        if(cur.next==null||cur.next.isEmpty()) {
            res.add(path.toString());
            return;
        }

        for (String key : cur.next.keySet()) {
            /*[易错+重难]这里必须回溯!而且注意回溯方法
            deleteCharAt()不可以,因为要删的不是最后一个,而是好几位,所以用path.setLength(len);
            * */
            int len = path.length();
            path.append("/"+key);
            dfs(cur.next.get(key),res,path);
            path.setLength(len);
        }
        //path.setLength(len);
        //path.deleteCharAt(path.length()-2);
    }

    private void find(String[] fol, int level, Node cur) {
        //fol[]是当前遍历到的,比如若fol =0 a b
        //如果到这就没有了,我就这个就是子类,就不应该往里加
        //如果到这还有,那说明 abc abd的关系,我这个d应该往里面加
        //level =1
        if(level>=fol.length){
            //那说明我现在已经超过了,fol是更短的(父类)
            cur.next = null;
            return;
        }
        if (cur.next==null){return;}
        if(cur.next.containsKey(fol[level])){
            find(fol,level+1,cur.next.get(fol[level]));
        }else {
            Node node = new Node(fol[level]);
            cur.next.put(fol[level],node);
            find(fol,level+1,node);
        }

    }
    class Node{
        String name;
        Map<String,Node> next;
        //Set<Node> next;
        Node(String name){
            this.name = name;
            this.next = new HashMap<>();
        }
    }


    public static void main(String[] args) {
        l1233 solution = new l1233();
        solution.test();
    }
    private void test(){
        l1233.Node root = new Node("root");
        Node a = new Node("a");Node b = new Node("b");Node c = new Node("c");
        Node d = new Node("d");Node e = new Node("e");Node f = new Node("f");

        root.next.put("a", a);root.next.put("c", c);
        a.next.put("b", b);c.next.put("d", d);c.next.put("f", f);d.next.put("e", e);

        List<String> res = new ArrayList<>();
        dfs(root,  res, new StringBuilder());
        for (String s : res) {
            System.out.println(s);
        }
    }
}

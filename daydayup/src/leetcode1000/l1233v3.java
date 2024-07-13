package leetcode1000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *字典树,感觉很难,不是随便能想起来的,要不直接冲v1吧
 * b站讲字典树的视频 ，但是我感觉，，也不太符合啊，，
 * 【【数据结构】字典树（Trie）】 <a href="https://www.bilibili.com/video/BV1k34y1p7sz/?share_source=copy_web&vd_source=5065f68c406b0886750222d297db870b">...</a>
 字典树画出来的图长这样
 Root (fid = -1)
 │
 ├── a (fid = 0)
 │   └── b (fid = 1)
 │
 ├── c (fid = -1)
 │   ├── d (fid = 2)
 │   │   └── e (fid = 3)
 │   └── f (fid = 4)

 字典树怎么解这道题（只取父节点）？就在于构建好，遍历的时候，碰到第一个不为-1的值就返回，
 */

public class l1233v3 {
    public static void main(String[] args) {
        l1233v3 solution = new l1233v3();
        String[] in = new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"};
        solution.removeSubfolders(in);
    }
    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();
        for (int i = 0; i < folder.length; i++) {
            trie.insert(i,folder[i]);
        }
        //经过👆这一步,这个结构已经出来了,剩下的就是打印(取出来)就行了
        trie.print(trie,0);
        //
        List<String> res = new ArrayList<>();
        List<Integer> search = trie.search();
        System.out.println(search);//[0, 2, 4]
        for (int i : search) {
            res.add(folder[i]);//
        }
        return res;
    }

    // Trie 是前缀树（Prefix Tree），也称为字典树。 定义Trie ,用于检索字符串集合中的某个字符串，在前缀匹配问题。
    class Trie{
        //这个Map<String, Trie> children 和我v0的思路有一点点点像,但是后面完全不同了
        //Trie这个类甚至可以省略自己节点的名字，当然加上去打印出来更直观
        private Map<String, Trie> children = new HashMap<>();
        private int fid = -1;
        //[答案说:]如果当前节点的 fid 字段不为 -1，则说明当前节点对应的文件夹是答案数组中的一个文件夹，    那最后遍历的时候，我们将其加入答案数组并且返回。
        // 否则（那说明不是一个单词---合法路径），我们递归地搜索当前节点的所有子节点，最终返回答案数组。
        //fid唯一标识文件夹路径的整数索引    fid代表取String[] folder的第几位
        /*
Root (fid = -1)
│
├── a (fid = 0)
│   └── b (fid = 1)
│
├── c (fid = -1)
│   ├── d (fid = 2)
│   │   └── e (fid = 3)
│   └── f (fid = 4)
         */
        /**
         * 说明这个方法会改调用者在自己的值fid 和children
         * @param fid
         * @param f
         */
        public void insert(int fid,String f){
            //System.out.println("insert,fid:"+fid+",f:"+f);
            Trie node = this;

            String[] ps = f.split("/");// f = /a/b/c
            for(int i=1; i<ps.length; i++){
                String p = ps[i];//a b c
                if(!node.children.containsKey(p)){  //如果insert的调用者的children里没有b
                    node.children.put(p, new Trie());//那就往insert的调用者的children里加一个b键,值是一个新的Trie()
                }
                node = node.children.get(p);//然后就可以拿出来啦
            }
            //node.fid设置为最后一个位值的fid
            node.fid = fid;
        }

        /**
         * 搞2层设计是有好处的，search就负责包装一下dfs,造一个res并返回
         * @return
         */
        public List<Integer> search() {
            List<Integer> res = new ArrayList<>();
            dfs(this, res);
            return res;
        }

        private void dfs(Trie root, List<Integer> res) {
            if (root.fid != -1) {//如果不是-1说明这是一个合法的路径.且这个只要达到第一个不为-1的，马上就返回了，不管之后了，所以能取出父文件夹
                res.add(root.fid);
                return;
            }
            for (var child : root.children.values()) {
                dfs(child, res);
            }
        }

        private void print(Trie root, int level){
            String indent = "  ".repeat(level);
            System.out.println(indent+"fid= "+root.fid+" children:"+root.children.keySet());
            for (String s : root.children.keySet()) {
                print(root.children.get(s),level + 1);
            }
        }

        /**
         * chatgpt写的打印防方式
         * @param node
         * @param sb
         * @param depth
         * @param prefix
         */
        private void printTrie(Trie node, StringBuilder sb, int depth, String prefix) {
            if (depth == 0) {
                sb.append("Root (fid = -1)\n");
            } else {
                sb.append(prefix)
                        //.append(node.folderName)
                        .append(" (fid = ").append(node.fid).append(")\n");
            }

            for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
                printTrie(entry.getValue(), sb, depth + 1, prefix + (depth == 0 ? "├── " : "│   "));
            }
        }



    }
}
//        作者：ylb
//        链接：https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/solutions/2099333/python3javacgo-yi-ti-shuang-jie-pai-xu-z-dha2/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 /*
 /a     的 fid 是 0。
 /a/b   的 fid 是 1。
 /c/d   的 fid 是 2。
 /c/d/e 的 fid 是 3。
 /c/f   的 fid 是 4。
 */
/*  如果fid= -1，代表这不是一个单词的结尾
fid= -1 children:[a, c]
  fid= 0 children:[b]
    fid= 1 children:[]
  fid= -1 children:[d, f]
    fid= 2 children:[e]
      fid= 3 children:[]
    fid= 4 children:[]
*/
/*字典树画出来的图长这样
Root (fid = -1)
│
├── a (fid = 0)
│   └── b (fid = 1)
│
├── c (fid = -1)
│   ├── d (fid = 2)
│   │   └── e (fid = 3)
│   └── f (fid = 4)
 */
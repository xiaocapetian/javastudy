package leetcode300;

import java.util.*;

/**
 * 确实能一遍过,就是写的特别慢
 */
public class l399 {

    //为什么需要map,根据名字"a"随时查到那个节点
    Map<String,NumNode> map = new HashMap<>();
    //为什么需要索引,根据名字"a"随时查,序号,用来visited[]的下标
    Map<String,Integer> suoyin = new HashMap<>();
    //节点的格式
    class NumNode{
        String val;
        HashMap<NumNode,Double> next;
        NumNode(String val){
            this.val = val;
            this.next = new HashMap<>();//初创的时候要初始化
        }
    }

    /**
     * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * @param equations 输入：equations = [["a","b"],["b","c"]],
     * @param values values = [2.0,3.0],
     * @param queries queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        for (int i = 0; i < equations.size(); i++) {
            //对于起点和终点,同样的看待cur,和curnext,如果map里没有,那就new,否则取出来
            NumNode cur = map.getOrDefault(equations.get(i).get(0),new NumNode(equations.get(i).get(0)));
            map.put(equations.get(i).get(0),cur);
            NumNode curnext = map.getOrDefault(equations.get(i).get(1),new NumNode(equations.get(i).get(1)));
            map.put(equations.get(i).get(1),curnext);
            //分别加上对方
            cur.next.put(curnext,values[i]);
            curnext.next.put(cur,1/values[i]);
            //如果suoyin里没有,那也加上它
            if(!suoyin.containsKey(cur.val)){suoyin.put(cur.val,suoyin.size());}
            if(!suoyin.containsKey(curnext.val)){suoyin.put(curnext.val,suoyin.size());}
            //equations.get(i).get(0)
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if(!map.containsKey(queries.get(i).get(0))||!map.containsKey(queries.get(i).get(1))){
                //如果目标的首尾不在map里,那就直接-1
                res[i] = -1.0;
            }else {
                //准备一个 boolean[] visited
                boolean[] visited =new boolean[map.size()];
                visited[suoyin.get(queries.get(i).get(0))]=true;
                NumNode cur = map.get(queries.get(i).get(0));
                NumNode target = map.get(queries.get(i).get(1));
                double fen = 1;
                //dfs的时候传递的参数,当前节点,目标节点
                double score = dfs(cur,target,fen,visited);
                res[i] = score;
            }
        }
        return res;
    }

    private double dfs(NumNode cur, NumNode target, double fen,boolean[] visited) {
        if(cur==target){return fen;}//找到了就返回现在的fen
        double score=-1.0;//初始值设置为-1
        //对它的child遍历一轮
        for (Map.Entry<NumNode, Double> numNodeDoubleEntry : cur.next.entrySet()) {

            NumNode child = numNodeDoubleEntry.getKey();
            Double costfen = numNodeDoubleEntry.getValue();
            if(!visited[suoyin.get(child.val)]){
                visited[suoyin.get(child.val)]= true;
                double dfsres = dfs(child,target,fen*costfen,visited);
                if(dfsres!=-1){score = dfsres;}//这里注意,如果dfsres是-1代表找不到,那就别覆盖
                visited[suoyin.get(child.val)]= false;
            }
        }
        return score;
        //如果孩子没有符合条件的,那-1就会流传下来呀,
    }

}

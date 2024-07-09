package leetcode3000;

import java.util.*;

public class l3067v3 {
    /**
     * 给你一棵无根带权树，树中总共有 n 个节点，分别表示 n 个服务器，服务器从 0 到 n - 1 编号。
     * @param edges 同时给你一个数组 edges ，其中 edges[i] = [ai, bi, weighti] 表示节点 ai 和 bi 之间有一条双向边，边的权值为 weighti 。
     * @param signalSpeed 再给你一个整数 signalSpeed 。
     * @return 请你返回一个长度为 n 的整数数组 count ，其中 count[i] 表示通过服务器 i 可连接 的服务器对的 数目 。
     */
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {

        //对于一个节点m ,以它为头节点，如果他只用一个邻居，
        //那它到哪个点的距离不都得通过这一个邻居嘛？必然是0啊
        //那假设它拥有3个邻居   a b c
        //源点m到a+a到假设有3个点的举例符合要求（signalSpeed）的倍数
        //源点m到b+ b假设有4个点的举例符合要求
        //源点m到c+ c假设有5个点的举例符合要求
        //那么答案是 4*3  +  5*（3+4） 只考虑右半部分哦
        int len = edges.length+1;
        //Map<Integer,Integer>[] graph = new HashMap[len];
        List<int[]>[] graph = new ArrayList[len];
        //Arrays.fill(graph, new ArrayList<int[]>());
        /*[易错]这里一定要按照👇下面的来setAll , 每个都设置, 不会写你就老老实实遍历,向上面那个,那所有的都填充了一个相同的
         */
        Arrays.setAll(graph,i -> new ArrayList<>());
//        for (Map<Integer, Integer> map : graph) {
//            map = new HashMap<>();
//        }
        for (int[] edge : edges) {

            graph[edge[0]].add(new int[]{edge[1],edge[2]});
            graph[edge[1]].add(new int[]{edge[0],edge[2]});
        }

//        for (List<int[]> ints : graph) {
//            for (int[] anInt : ints) {
//                System.out.print(Arrays.toString(anInt)+"   ");
//            }
//            System.out.println();
//        }
        int[] res = new int[len];
        for(int i = 0;i<len;i++){
            //System.out.println("以第"+i+"个点为源点=================================");
            List<int[]> childs = graph[i];
            int childSize = childs.size();
            int sum = 0;
            /// System.out.println("i="+i+",childSize="+childSize);
            if(childSize!=1){
                int[] childarr = new int[childSize];
                int[] childSumarr = new int[childSize];
                int count = 0;
                for (int[] child : childs) {

                    //System.out.println("访问的邻居是第key="+child[0]+",value="+child[1]);
                    //List<Integer> validPoint = new ArrayList<>();
                    List<Integer> path = new ArrayList<>();
                    path.add(i);

                    //int validPoint = dfs1(child[0],child[1],signalSpeed,0,graph,path);
                    //int validPoint = dfs2(child[0],child[1],signalSpeed,graph,path);
                    int validPoint = dfs(child[0],i,child[1],signalSpeed,graph);
                    childarr[count] = validPoint;
                    // System.out.println("childarr[count]"+childarr[count]);
                    if(count>0){
                        childSumarr[count] =childarr[count-1]+childSumarr[count-1];
                        sum+=childarr[count]*childSumarr[count];
                    }
                    /*[易错]这里写👆时,一定要像下面👇那样把给列出来啊!列出来就清晰了*/
//以3 4 5为例,
//  childarr[0] =3   childarr[1] =4 childarr[2] =5
// childSumarr[0] =0, childSumarr[0] = 3, childSumarr[0] = 3+4
                    // System.out.println("childSumarr[count]"+childSumarr[count]);

                    count++;

                }

            }


            res[i] = sum;
        }
        return res;
    }

    /**
     * 下面两种dfs都会超时,原因就在于 不要用path来判断是不是重复了
     * 原因在于这个不是图!!是带权树!树有什么特点啊?只要不走回头路,就不会重复!
     * 也就是说不需要一个path来存走过哪些值,只需要一个pre存上一个节点就行
     * @param now
     * @param pre
     * @param cost
     * @param signalSpeed
     * @param graph
     * @return
     */
    //private void dfs(int now, int cost,int signalSpeed,List<Integer> validPoint,List<int[]>[] graph,List<Integer> path) {
    private int dfs(int now, int pre,int cost,int signalSpeed,List<int[]>[] graph) {
        //path.add(now);
        //System.out.println("now="+now+",cost="+cost+",signalSpeed="+signalSpeed);
        int validPoint=cost%signalSpeed==0?1:0;

        List<int[]> childs = graph[now];
        for (int[] child : childs) {
            //System.out.println("path="+path+",key="+child[0]);
            if(child[0]!=pre){
                //System.out.println("没有,可添加");
                validPoint+=dfs(child[0],now,cost+child[1],signalSpeed,graph);
            }

        }
        return validPoint;
    }
    /*2种递归方式!!!dfs1和dfs2,dfs是从上往下累加,validPoint需要在参数里传
    * 结论:用2更好!!!
    * */
    //private void dfs(int now, int cost,int signalSpeed,List<Integer> validPoint,List<int[]>[] graph,List<Integer> path) {
    private int dfs1(int now, int cost,int signalSpeed,int validPoint,List<int[]>[] graph,List<Integer> path) {
        path.add(now);
        //System.out.println("now="+now+",cost="+cost+",signalSpeed="+signalSpeed);
        if(cost%signalSpeed==0){
            //validPoint.add(now);
            validPoint++;
            //System.out.println("添加了"+now);
            //return;
        }
        List<int[]> childs = graph[now];
        for (int[] child : childs) {
            //System.out.println("path="+path+",key="+child[0]);
            if(!path.contains(child[0])){
                //System.out.println("没有,可添加");
                validPoint=dfs1(child[0],cost+child[1],signalSpeed,validPoint,graph,path);
                /*注意区别👆在这*/
            }

        }
        return validPoint;
    }
    /*dfs2是递归到底,设置为1,然后和上一轮递归的结果相加*/
    //private void dfs(int now, int cost,int signalSpeed,List<Integer> validPoint,List<int[]>[] graph,List<Integer> path) {
    private int dfs2(int now, int cost,int signalSpeed,List<int[]>[] graph,List<Integer> path) {
        path.add(now);
        int validPoint = 0;
        //System.out.println("now="+now+",cost="+cost+",signalSpeed="+signalSpeed);
        if(cost%signalSpeed==0){
            //validPoint.add(now);
            validPoint=1;
            //System.out.println("添加了"+now);
            //return;
        }
        List<int[]> childs = graph[now];
        for (int[] child : childs) {
            //System.out.println("path="+path+",key="+child[0]);
            if(!path.contains(child[0])){
                //System.out.println("没有,可添加");
                validPoint+=dfs2(child[0],cost+child[1],signalSpeed,graph,path);
                /*注意区别👆在这*/
            }

        }
        return validPoint;
    }
}

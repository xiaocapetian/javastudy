package leetcode700;

public class l787v4 {
    /**Bellman-Ford算法    8/3二刷我自己写的,现在我应该完全掌握理解这题了吧~   为什么要复制一个distance
     *
     * @param n 有 n 个城市通过一些航班连接
     * @param flights 给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
     * @param src 出发城市 src
     * @param dst  和目的地 dst，
     * @param k 找到出一条最多经过 k 站中转的路线，   ***注意** k 站中转 那边的个数是k+1
     * @return 使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] distence = new int[n];
        for (int i = 0; i < distence.length; i++) {
            distence[i] = Integer.MAX_VALUE;
        }
        distence[src] = 0;
        //中转点是k, 最大边数是k+1,遍历k+1轮
        /*[易错] 这里k+1是因为最大边数= k+1  不是k */
        k= k+1;
        for (int i = 0; i < k; i++) {
            /*[重难]自己写了一遍我就理解了,为什么说这里要加一个缓存,要求限制边数最大是k+1,那么这一轮中,我只能用上一轮的distence[i]来计算
            * 不能在一轮中,用本轮更新的,那就中转次数多了*/
            int[] distanceCache = new int[n];
            for (int i1 = 0; i1 < distanceCache.length; i1++) {
                distanceCache[i1] = distence[i1];
            }
            //System.out.println("distanceCache"+Arrays.toString(distanceCache));
            //每一轮我都要遍历所有的边
            for (int j = 0; j < flights.length; j++) {
                //System.out.println("起点"+flights[j][0]+"距离"+distanceCache[flights[j][0]]+"终点"+flights[j][1]+"距离"+distence[flights[j][1]]);
                /*[易错]这里要在distanceCache[flights[j][0]]!=Integer.MAX_VALUE ,起点距离不是无穷大时才考虑,因为Integer.MAX_VALUE计算会溢出成负数*/
                if(distanceCache[flights[j][0]]!=Integer.MAX_VALUE&&distence[flights[j][1]]>distanceCache[flights[j][0]]+flights[j][2]){
                    distence[flights[j][1]] = distanceCache[flights[j][0]]+flights[j][2];
                }
                //System.out.println(Arrays.toString(distence));
            }

        }

        return distence[dst]==Integer.MAX_VALUE?-1:distence[dst];  /*[易错]这里不能直接返回吧,如果=Integer.MAX_VALUE,那得返回-1*/
    }
}

package leetcode700;

public class l787study {
    //邻接表存图 本图中 点数为n，边数为m
    int N;
    int M;
    //he 数组：存储是某个节点所对应的边的集合（链表）的头结点；
    //e  数组：由于访问某一条边指向的节点；
    //ne 数组：由于是以链表的形式进行存边，该数组就是用于找到下一条边；
    //w  数组：用于记录某条边的权重为多少。
    int[] he = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int[] w = new int[M];
    int idx;
    public static void main(String[] args) {
        l787study s = new l787study();
        //int[][] flights = {{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}};
        //s.findCheapestPrice(5,flights,2,1,1);

        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        s.findCheapestPrice(4,flights,0,3,1);
    }
    void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        w[idx] = c;
        idx++;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        M = flights.length;
        N = n;

        return 1;
    }
}

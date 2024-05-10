package nowcoder.XiaoHongShu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.cnblogs.com/ganyq/p/18124015
public class redtree {
    static boolean[] isNotPrime; // true 表示为合数
    static int[] value;
    static List<Integer>[] next;
    static int res;
    public static void main(String[] args) {
        //final long MOD = (long) (1e9 + 7);
        // 题目数据 a 最大为1e5 两数相加最大2e5 所以我们只需要筛出2e5之前的素数即可
        final int MAXN = (int) (2e5 + 10);

        // 欧拉筛法（Sieve of Euler），用于快速生成素数列表。
        isNotPrime = new boolean[MAXN];
        List<Integer> primes = new ArrayList<>();//用于存储找到的素数。

        for(int i = 2; i < MAXN; i++){
            if(!isNotPrime[i])
                primes.add(i);
            for(int prime: primes){//只遍历合数
                if(i * prime >= MAXN)//超出范围当然break
                    break;
                isNotPrime[i * prime] = true;

                if(i % prime == 0)//4遇到2后就结束本轮遍历,为什么?3*4=12,你把12筛出了,那后面6筛谁去?
                    break;
            }
        }

        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();

        value = new int[n + 1];
        next = new List[n + 1];//List<Integer>[]

        //保存节点值
        for(int i = 1; i <= n; i++) {
            value[i] = scanner.nextInt();
            next[i] = new ArrayList<>();
        }
        //建树
        for(int i = 1; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            next[x].add(y);
            next[y].add(x);
        }

        // 把1看作根节点
        dfs(1, -1);
        System.out.println(res);
    }

    private static void dfs(int cur, int pre){
        //对节点cur的所有子节点标注
        for(int nxt: next[cur]){
            if(nxt == pre) // pre为父节点 防止反走
                continue;
            dfs(nxt, cur);

            int check = value[cur] + value[nxt];
            //能染就染 反正染的是儿子节点 不关父节点的事
            if(!isNotPrime[check]){
                res++;
            }
        }
    }
}

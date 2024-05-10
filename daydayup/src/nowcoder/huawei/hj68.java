package nowcoder.huawei;

import java.util.*;

/**
 * 想让优先队列在分数相等时按照加入顺序排序,可以方法一,在加入的元素里加上加入顺序
 * 也可以方法二,再建一个hashmap来存元素和加入顺序的映射
 */
public class hj68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            int bool = Integer.parseInt(in.nextLine());
            //TreeMap<Integer,String> treeMap;
            PriorityQueue<String> pq;
            if(bool==1){//低到高
                pq = new PriorityQueue<>((o1, o2) -> {
                    int o1fen = Integer.parseInt(o1.split(" ")[1]);
                    int o2fen = Integer.parseInt(o2.split(" ")[1]);
                    if(o1fen!=o2fen)return o1fen-o2fen;
                    else {
                        return Integer.parseInt(o1.split(" ")[2])-Integer.parseInt(o2.split(" ")[2]);
                    }
                });
            }else {
                pq = new PriorityQueue<>(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int o1fen = Integer.parseInt(o1.split(" ")[1]);
                        int o2fen = Integer.parseInt(o2.split(" ")[1]);
                        if(o1fen!=o2fen)return o2fen-o1fen;
                        else {
                            return Integer.parseInt(o1.split(" ")[2])-Integer.parseInt(o2.split(" ")[2]);
                        }
                    }
                });
            }

            for (int i = 0; i < n; i++) {
                String s = in.nextLine()+" "+i;
                pq.add(s);
            }
            while (!pq.isEmpty()){
                String poll = pq.poll();
                String res = poll.substring(0, poll.lastIndexOf(" "));
                System.out.println(res);
            }
        }
    }
}

package nowcoder.huawei;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class hj68v1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            int bool = Integer.parseInt(in.nextLine());
            //TreeMap<Integer,String> treeMap;
            PriorityQueue<String> pq;
            HashMap<String,Integer> map = new HashMap<>();
            if(bool==1){//低到高
                pq = new PriorityQueue<>(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int o1fen = Integer.parseInt(o1.split(" ")[1]);
                        int o2fen = Integer.parseInt(o2.split(" ")[1]);
                        if(o1fen!=o2fen)return o1fen-o2fen;
                        else {
                            return map.get(o1)-map.get(o2);
                        }
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
                            return map.get(o1)-map.get(o2);
                        }
                    }
                });
            }

            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                //String s = in.nextLine()+" "+i;
                map.put(s,i);
                pq.add(s);
            }
            while (!pq.isEmpty()){
                System.out.println(pq.poll());
            }
        }
    }
}

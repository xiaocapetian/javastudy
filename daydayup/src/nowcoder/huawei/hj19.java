package nowcoder.huawei;

import java.util.*;

/**
 * 题解
 * 重难点,同时维护一个map一个队列queue
 */
public class hj19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] ns = line.split(" ");
            String[] ls = ns[0].split("\\\\");
            String name = ls[ls.length-1];
            name = name.length() > 16 ? name.substring(name.length()-16) : name;
            name += " " + Integer.valueOf(ns[1]);
//这里是一种巧妙的改进 queue怎么用?  //即使是重的也别从map里移除,map里依然在,queue移除了就移除了
            if (map.get(name) == null) {
                map.put(name, 1);
                if (queue.size() == 8) {
                    queue.poll();
                }
                queue.add(name);
            } else {
                map.put(name, map.get(name) + 1);
            }
        }

        for(String s : queue) {
            System.out.println(s + " " + map.get(s));
        }
    }
}

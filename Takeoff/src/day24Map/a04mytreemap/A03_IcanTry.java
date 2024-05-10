package day24Map.a04mytreemap;

import java.util.TreeMap;
import java.util.function.BiConsumer;

public class A03_IcanTry {
    /* 需求：
        字符串“aababcabcdabcde”
        请统计字符串中每一个字符出现的次数，并按照以下格式输出
        输出结果：
        a（5）b（4）c（3）d（2）e（1）

            新的统计思想：利用map集合进行统计

          如果题目中没有要求对结果进行排序，默认使用HashMap
          如果题目中要求对结果进行排序，请使用TreeMap

          键：表示要统计的内容
          值：表示次数

        */
    public static void main(String[] args) {
        //1.定义字符串
        String s = "aababcabcdabcde";

        //2.创建集合
        TreeMap<Character,Integer> tm = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
           char ch = s.charAt(i);
            if (tm.containsKey(ch)){
                int count = tm.get(ch);
                count++;
                tm.put(ch, count);
            }else {
                tm.put(ch,1);
            }
        }
        System.out.println(tm);
        StringBuilder sb = new StringBuilder();
        tm.forEach(new BiConsumer<Character, Integer>() {
            @Override
            public void accept(Character key, Integer value) {
                sb.append(key).append("(").append(value).append(")");
            }
        });
        System.out.println(sb);

    }



}

package day26.A02mystream.a01mystream;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StreamDemo3 {
    public static void main(String[] args) {
        //双列集合      无                   无法直接使用stream流

//所以需要，转换成单列集合
        //1.创建双列集合
        HashMap<String,Integer> hm = new HashMap<>();
        //2.添加数据
        hm.put("aaa",111);
        hm.put("bbb",222);
        hm.put("ccc",333);
        hm.put("ddd",444);

        //3.第一种获取stream流
        System.out.println("最初的HashMap<String,Integer>");
        System.out.println(hm);//{aaa=111, ccc=333, bbb=222, ddd=444}

        System.out.println("转换成Set<String> strings 用 hm.keySet()");
        Set<String> strings = hm.keySet();
        System.out.println(hm.keySet());//[aaa, ccc, bbb, ddd]

        System.out.println("转换成Set<Map.Entry<String, Integer>> entries 用 hm.entrySet()");
        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        System.out.println(hm.entrySet());//[aaa=111, ccc=333, bbb=222, ddd=444]

        hm.keySet().stream().forEach(s -> System.out.println(s));

        //4.第二种获取stream流
        hm.entrySet().stream().forEach(s-> System.out.println(s));
    }
}

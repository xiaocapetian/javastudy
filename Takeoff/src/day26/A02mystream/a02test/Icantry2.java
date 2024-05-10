package day26.A02mystream.a02test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Icantry2 {
    public static void main(String[] args) {
               /*
        练习：
        创建一个ArrayList集合，并添加以下字符串，字符串中前面是姓名，后面是年龄
            "zhangsan,23"
            "lisi,24"
            "wangwu,25"
        保留年龄大于等于24岁的人，并将结果收集到Map集合中，姓名为键，年龄为值*/
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,"zhangsan,23","lisi,24","wangwu,25");

        Map<String, Integer> collect = arrayList.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
        System.out.println(collect);

        //匿名内部类
        arrayList.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .collect(Collectors.toMap(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return null;
                    }
                }, new Function<String, Object>() {
                    @Override
                    public Object apply(String s) {
                        return null;
                    }
                }));
    }
}

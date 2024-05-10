package day24Map.a01mymap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class A02_MapDemo2 {
    public static void main(String[] args) {
        //Map集合的第一种遍历方式  ----- 键找值

        //三个课堂练习：
        //
        //练习一：  利用键找值的方式遍历map集合，要求：装着键的单列集合使用增强for的形式进行遍历
        //练习二：  利用键找值的方式遍历map集合，要求：装着键的单列集合使用迭代器的形式进行遍历
        //练习三：  利用键找值的方式遍历map集合，要求：装着键的单列集合使用lambda表达式的形式进行遍历


        //1.创建Map集合的对象
        Map<String,String> map = new HashMap<>();
        //2.添加元素
        map.put("k1","q1");
        map.put("k2","q2");
        map.put("k3","q3");

        //3.通过键找值

        //3.1获取所有的键，把这些键放到一个单列集合当中
        Set<String> keys = map.keySet();

        //3.2遍历单列集合，得到每一个键
        //三种遍历方法
        //3.2.1增强for
        for (String key : keys) {
            //System.out.println(key);
            //3.3 利用map集合中的键获取对应的值  get
            String value = map.get(key);//map的get
            System.out.println(key + " = " + value);
        }

        //3.2.2 迭代器
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key = it.next();
            String value = map.get(key);//map的get
            System.out.println(key + " =2 " + value);
        }

        //3.2.3使用lambda表达式
        keys.forEach(new Consumer<String>() {//注意在这里打con..是不会有自动提示的，相反打new，有自动提示
            @Override
            public void accept(String s) {
                String key = s;
                String value = map.get(key);//map的get
                System.out.println(key + " =3 " + value);
            }
        });


    }
}

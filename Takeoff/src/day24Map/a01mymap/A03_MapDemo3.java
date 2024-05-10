package day24Map.a01mymap;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class A03_MapDemo3 {
    public static void main(String[] args) {
        //Map集合的第二种遍历方式

        //三个课堂练习：
        //
        //练习一：  通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用增强for的形式进行遍历
        //练习二：  通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用迭代器的形式进行遍历
        //练习三：  通过键值对对象进行遍历map集合，要求：装着键值对对象的单列集合使用lambda的形式进行遍历

        //1.创建Map集合的对象
        Map<String, String> map = new HashMap<>();

        //2.添加元素
        //键：人物的外号
        //值：人物的名字
        map.put("k1", "q1");
        map.put("k2", "q2");
        map.put("k3", "q3");

       /* //3.Map集合的第二种遍历方式
        //通过键值对对象进行遍历
        //3.1 通过一个方法获取所有的键值对对象，返回一个Set集合*/
        //【也就是说，把map的东西先放到set里，再遍历set】
        Set<Map.Entry<String, String>> entries = map.entrySet();
        System.out.println("entries is "+entries);
        //写这句话先写右边自动补全左边就行
        //map接口下的entry接口
        //3.2 遍历entries这个集合，去得到里面的每一个键值对对象
        for (Map.Entry<String, String> entry : entries) {//entry  --->  "御龙骑士","尹志平"
            //3.3 利用entry调用get方法获取键和值
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }

        System.out.println("-----------------------------------");
        //不用中间商entries 了，直接把这个map.entrySet()塞进去
        for (Map.Entry<String, String> entry :  map.entrySet()) {
            //3.3 利用entry调用get方法获取键和值
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }

    }
}
package day26.A03myfunction.a01myfunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;

public class FunctionDemo6 {
    public static void main(String[] args) {
        /*
        方法引用（数组的构造方法）
        格式
                数据类型[]::new
        目的：
                就是为了创建一个指定类型的数组   目前看到的都是这样用:   .toArray(Integer[]::new);
        需求：
             集合中存储一些整数，收集到数组当中

        细节：
            数组的类型，需要跟流中数据的类型[保持一致]。

       */

        //1.创建集合并添加元素
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        //2.收集到数组当中

        Integer[] arr2 = list.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr2));

        Integer[] arr3 = list.stream().toArray(Integer[]::new);
        Integer[] arr4 = list.toArray(Integer[]::new);


        //最开始,我们是这样写的
        list.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });
        //用lamda简化是这样
        list.stream().toArray(value -> new Integer[value]);
        //现在,方法引用,数组,应该这样
        list.stream().toArray(Integer[]::new);
        /**/


    }
}

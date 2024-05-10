package day26.A02mystream.a02test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Icantry1 {
    public static void main(String[] args) {
         /*
        定义一个集合，并添加一些整数  1,2,3,4,5,6,7,8,9,10
        过滤奇数，只留下偶数。
        并将结果保存起来
       */
        ArrayList<Integer> arrayList = new ArrayList<>();
        //怎么往里面加?别忘了
        Collections.addAll(arrayList,1,2,3,4,5,6,7,8,9,10);

        //首先用collect(Collectors.toList())
        List<Integer> collect = arrayList.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);

        //下面试一下 .toArray
        Integer[] array = arrayList.stream().filter(s -> s % 2 == 0).toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });

        System.out.println(Arrays.toString(array));
    }
}

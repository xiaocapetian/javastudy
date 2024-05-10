package leetcode300;

import java.util.HashSet;
import java.util.Set;
import java.util.function.ToIntFunction;

public class l349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hash = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hash.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(hash.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }

        //方法引用
        int[] result = res.stream().mapToInt(Integer::valueOf).toArray();//难点就是这个怎么想
        //匿名内部类
        int[] result2 = res.stream().mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
        }).toArray();
        //lamda
        int[] result3 = res.stream().mapToInt (value-> value).toArray();
//这么写是不行,因为.stream()之后就变成object类型了,
        //int[] result4 = res.stream().toArray();

        //方法4,不转了,重新建一个数组,把set里的元素放进去,结果速度反而是最快的
        int[] result4 = new int[res.size()];//set中元素是无序的,没法根据索引来查
        int index = 0;
        for (Integer num : res) {
            result4[index++] = num; // 将当前元素放入数组，并将索引后移
        }
        return result;
    }
}

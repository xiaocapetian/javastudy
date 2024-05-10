package DataStructure;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        // 创建一个 TreeSet 对象
        Set<Integer> set = new TreeSet<>();

        // 向 TreeSet 中添加元素
        set.add(5);
        set.add(3);
        set.add(8);
        set.add(1);
        set.add(4);
        set.add(3); // 添加重复元素

        // 输出 TreeSet 中的元素，会按照自然顺序排序且去重
        System.out.println("Sorted Set with Duplicates: " + set);
    }
}

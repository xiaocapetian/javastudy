package go;

import java.util.Arrays;
import java.util.Comparator;
//怎么对一个数组(字符串)排序呢
//java排序怎么写出来呢
public class arraysSort {
    public static void main(String[] args) {
        String[] strs = {"apple", "banana", "orange", "grape", "kiwi"};

        //方法一:
        //最复杂的方法//建一个子类实现这个接口,然后创建子类的对象
        Arrays.sort(strs, new StringLengthComparator());

        //方法二:
        //匿名内部类
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        //再简化
        Arrays.sort(strs, (o1, o2)-> {
                return o1.length() - o2.length();});

        System.out.println("按照字符串长度升序排序后的数组：");
        for (String str : strs) {
            System.out.println(str);
        }
    }

    static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }
}

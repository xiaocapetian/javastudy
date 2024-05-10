package go;

import java.util.HashSet;
import java.util.Set;

public class SetToArr {
    //怎么把一个set里的东西放进数组呢?
    public static void main(String[] args) {
        stream();
        toArray();
    }
    public static void stream(){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        //stream流法   将 Set 转换为整型数组
        int[] result = set.stream().mapToInt(Integer::intValue).toArray();
        // 2.  toArray() 方法将 Set 转换为整数数组
        Integer[] array = set.toArray(new Integer[0]);
        for (int i : result) {
            System.out.println(i);
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
    public static void toArray(){
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("orange");
/*        String str1 = new String("ddd ddda");
        String[] s = str1.split(" ");
        str1.toCharArray();*/
        //toArray法     将 Set 转换为字符串数组
        String[] result = set.toArray(new String[0]);

        // 打印结果
        for (String str : result) {
            System.out.println(str);
        }
    }

}

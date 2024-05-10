package go;

import java.util.*;

public class collection {
    public static void main(String[] args) {
        //tt();
        SettoArr();
        //SettoArr2();
    }

    public static void SettoArr(){
        // 假设 res 是你的 Set<Integer>
        Set<Integer> res = new HashSet<>();
        res.add(1);
        res.add(2);
        res.add(3);

        // 将 Set<Integer> 转换为 int[] 数组
        int[] result = res.stream().mapToInt(Integer::intValue).toArray();
        Integer[] res1 =res.toArray(new Integer[res.size()]);
        Integer[] res2 =res.toArray(new Integer[0]);

        Integer[] res3 = new Integer[res.size()];
        Integer[] res33 = res.toArray(res3);//toArray()传进的数组res3如果够大,就会把set转成的数组存进res3里
        //此时就算返回,返回的res33也和res3,是同一个东西
        //        System.out.println(res3);
        //        System.out.println(res33);
        //        System.out.println(Arrays.toString(res3));
        //        System.out.println(Arrays.toString(res33));

        Integer[] res4 = new Integer[res.size()-1];
        Integer[] res5 = res.toArray(res4);  //toArray()传进的数组长度不足，或者为 null，则会创建一个新的数组，并返回该数组
        //System.out.println(Arrays.toString(res4));  //res4继续为1空
        //System.out.println(Arrays.toString(res5));  //新造一个res5

        // 输出结果
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));




    }
    public static void SettoArr2(){
        // 假设 res 是你的 Set<String>
        Set<String> res = new HashSet<>();
        res.add("apple");
        res.add("banana");
        res.add("orange");

        // 将 Set<String> 转换为 String[] 数组
        String[] result = res.toArray(new String[0]);

        // 输出结果
        System.out.println(Arrays.toString(result));
    }
    public static void tt(){
        List<Integer> res1 = new ArrayList<>();
        res1.add(1);res1.add(2);
        Integer[] result1 = res1.toArray(new Integer[res1.size()]);
        System.out.println(Arrays.toString(result1));
//        for (Integer integer : result1) {
//            System.out.print(integer+",");
//        }
        System.out.println();
        List<String> res12 = new ArrayList<>();
        res12.add("1-");res12.add("2-");
        //Integer[] result13 = res12.toArray(new Integer[res12.size()]);//编译不报错,运行报错
        String[] result12 = res12.toArray(new String[res12.size()]);
//        for (String str : result12) {
//            System.out.print(str+",");
//        }
        System.out.println(Arrays.toString(result12));
        //List<int[]>转int[][]
        List<int[]> res2 = new ArrayList<>();
        int[][] result2 = res2.toArray(new int[res2.size()][]);
    }
}

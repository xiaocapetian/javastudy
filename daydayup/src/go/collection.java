package go;

import java.util.*;

public class collection {
    public static void main(String[] args) {
        //tt();
        SettoArr();
        //SettoArr2();
    }

    public static void SettoArr(){
        // 假设 set 是你的 Set<Integer>
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        // 将 Set<Integer> 转换为 int[] 数组
        int[] result = set.stream().mapToInt(Integer::intValue).toArray();
        Integer[] res1 =set.toArray(new Integer[set.size()]);
        Integer[] res2 =set.toArray(new Integer[0]);

        System.out.println("result"+Arrays.toString(result));
        System.out.println("res1"+Arrays.toString(res1));
        System.out.println("res2"+Arrays.toString(res2));

        Integer[] res3 = new Integer[set.size()];
        //set.toArray(res3)  这一步会把set转成的数组存进res3里
        Integer[] res33 = set.toArray(res3);//toArray()传进的数组res3如果够大,就会把set转成的数组存进res3里
        //此时就算返回,返回的res33也和res3,是指向一模一样的一个东西
        System.out.println("res3"+res3);      //[Ljava.lang.Integer;@4f3f5b24
        System.out.println("res33"+res33);    //[Ljava.lang.Integer;@4f3f5b24
        System.out.println("res3"+Arrays.toString(res3));
        System.out.println("res33"+Arrays.toString(res33));

        Integer[] res4 = new Integer[set.size()-1];
        Integer[] res5 = set.toArray(res4);  //toArray()传进的数组长度不足，或者为 null，则会创建一个新的数组，并返回该数组
        System.out.println("res4"+Arrays.toString(res4));  //[null, null]   //res4继续为1空
        System.out.println("res5"+Arrays.toString(res5));  //[1, 2, 3]    //新造一个res5

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

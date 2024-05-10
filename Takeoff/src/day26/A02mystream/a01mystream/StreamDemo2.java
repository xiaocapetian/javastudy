package day26.A02mystream.a01mystream;


import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
/*
        单列集合      default Stream<E> stream()                           Collection中的默认方法
        双列集合      无                                                   无法直接使用stream流
        数组          public static <T> Stream<T> stream(T[] array)        Arrays工具类中的静态方法
        一堆零散数据   public static<T> Stream<T> of(T... values)           Stream接口中的静态方法
*/

        //1.单列集合获取Stream流
        ArrayList<String> list = new ArrayList<>();
        String[] str = new String[]{"7","a","b","c"};
        Collections.addAll(list,str);//可以看到，可变参是可以用数组代替的
        Collections.addAll(list,"a","b","c","d","e");

        //获取到一条流水线，并把集合中的数据放到流水线上
        Stream<String> stream1 = list.stream();
        //使用终结方法打印一下流水线上的所有数据
        stream1.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                //s:依次表示流水线上的每一个数据
                System.out.println(s);
            }
        });
        //简化
        list.stream().forEach(s -> System.out.println(s));


    }
}








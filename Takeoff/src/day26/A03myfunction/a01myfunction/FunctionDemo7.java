package day26.A03myfunction.a01myfunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FunctionDemo7 {
    public static void main(String[] args) {
        /*    P50
        需求：
             集合中存储一些字符串的数据，比如：张三,23。
             收集到Student类型的数组当中    ----既然要放到数组中,那自然要
       */
        //1.创建集合并添加元素
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌,15", "周芷若,14", "赵敏,13", "张强,20", "张三丰,100", "张翠山,40", "张良,35", "王二麻子,37", "谢广坤,41");
        //2.先把字符串变成Student对象，然后再把Student对象收集起来
        Student[] arr = list.stream().map(Student::new).toArray(Student[]::new);
        //                 这个student的构造方法  ↑
        //                                         这个是数组的构造方法  ↑
        //打印数组
        System.out.println(Arrays.toString(arr));


    }
}

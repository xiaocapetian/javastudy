package day26.A03myfunction.a01myfunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionDemo4 {
    public static void main(String[] args) {
        /*
        方法引用（引用构造方法）
        格式
                类名::new

        目的：
                创建这个类的对象

        需求：
             集合里面存储姓名和年龄，要求封装成Student对象并收集到List集合中

        方法引用的规则：
            1.需要有函数式接口
            2.被引用的方法必须已经存在
            3.被引用方法的形参和返回值，需要跟抽象方法的形参返回值保持一致
            4.被引用方法的功能需要满足当前的需求
       */

        //1.创建集合对象
        ArrayList<String> list = new ArrayList<>();
        //2.添加数据
        Collections.addAll(list, "张无忌,15", "周芷若,14", "赵敏,13", "张强,20", "张三丰,100", "张翠山,40", "张良,35", "王二麻子,37", "谢广坤,41");
        //3.封装成Student对象并收集到List集合中

        //过去是这样写的
        List<Student> lists = list.stream().map(s -> {
            return new Student(s.split(",")[0], Integer.parseInt(s.split(",")[1]));
        }).collect(Collectors.toList());
        System.out.println(lists);


        //String --> Student 完整是这样写的
        List<Student> newList = list.stream().map(new Function<String, Student>() {
            @Override
            public Student apply(String s) {
                String[] arr = s.split(",");
                String name = arr[0];
                int age = Integer.parseInt(arr[1]);
                return new Student(name, age);
            }
        }).collect(Collectors.toList());
        System.out.println(newList);

        //虽然这样写我懵逼了,但是只去看student类,原来已经新写了一个构造方法,专门应对扔进去一个String s,返回一个Student
        //相当于把替换了上文中重写的public Student apply(String s)
        List<Student> lists2 = list.stream().map(
                Student::new
        ).collect(Collectors.toList());
        System.out.println(lists2);


        List<Student> newList2 = list.stream().map(Student::new).collect(Collectors.toList());
        System.out.println(newList2);

    }
}
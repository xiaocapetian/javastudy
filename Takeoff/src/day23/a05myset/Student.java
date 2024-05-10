package day23.a05myset;

import java.util.Objects;
//实现这个Comparable接口，这个接口是泛型接口，那么法一，实现类指定泛型
//法二，实现类延续泛型，创建student类的时候才指定泛型
//这里用的是第一种
public class Student implements Comparable<Student>{
    private String name;
    private int age;


    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

    @Override
    //this：表示当前要添加的元素
    //o：表示已经在红黑树存在的元素

    //返回值：
    //负数：表示当前要添加的元素是小的，存左边
    //正数：表示当前要添加的元素是大的，存右边
    //0 :表示当前要添加的元素已经存在，舍弃
    public int compareTo(Student o) {
        System.out.println("--------------");
        System.out.println("this:" + this);
        System.out.println("o:" + o);


        //指定排序的规则
        //只看年龄，我想要按照年龄的升序进行排列
        return this.getAge() - o.getAge();
        //o 已经存在的元素
        //this 当前要添加的元素
    }
}

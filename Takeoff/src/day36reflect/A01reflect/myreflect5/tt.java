package day36reflect.A01reflect.myreflect5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class tt {
    public static void main(String[] args) throws IllegalAccessException, IOException {
    /*
        对于任意一个对象，都可以把对象所有的字段名和值，保存到文件中去
    */
        Student s = new Student("小A",23,'女',167.5,"睡觉");
        Teacher t = new Teacher("播妞",10000);
        saveObject(s);
        //saveObject(t);
    }

    private static void saveObject(Object obj) throws IllegalAccessException, IOException {
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();//成员变量的列表
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("Takeoff\\src\\day36reflect\\A01reflect\\myreflect5\\a.txt"));
        for (Field field : fields) {
            field.setAccessible(true);
            //获取成员变量的名字
            String name = field.getName();
            //获取成员变量的值(注意,这里
            Object value = field.get(obj);
            //System.out.println(name + "=" + value);
            bw.write(name + "=" + value);
            bw.newLine();
        }
        bw.close();


    }

}

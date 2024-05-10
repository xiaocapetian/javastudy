package day30_IO_test.A01io_test.myiotest2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
        /*需求：
            需求：
                有一个文件里面存储了班级同学的信息，每一个信息占一行。
                格式为：张三-男-23
                要求通过程序实现随机点名器。

            运行效果：
                第一次运行程序：随机同学姓名1（只显示名字）
                第二次运行程序：随机同学姓名2（只显示名字）
                第三次运行程序：随机同学姓名3（只显示名字）
                …
         */

        //1.读取文件中学生的姓名
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("myiotest\\src\\com\\itheima\\myiotest2\\names.txt"));
        String line;
        while ((line = br.readLine()) != null){
            list.add(line);
        }
        br.close();

        //2.随机抽取(解法一)
        Random r = new Random();
        int index = r.nextInt(list.size());
        String randomName1 = list.get(index);
        String[] arr1 = randomName1.split("-");
        System.out.println(arr1[0]);


        //2.随机抽取(解法二)
        Collections.shuffle(list);
        String randomName2 = list.get(0);
        String[] arr2 = randomName2.split("-");
        System.out.println(arr2[0]);


    }
}

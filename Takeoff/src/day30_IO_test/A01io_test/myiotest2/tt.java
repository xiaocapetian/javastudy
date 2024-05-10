package day30_IO_test.A01io_test.myiotest2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class tt {
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
        File file = new File("Takeoff\\src\\day30\\A01io_test\\myiotest1\\info.txt");
        String result = dianming(file);
        System.out.println(result);
    }

    private static String dianming(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String info;
        ArrayList<String> nameList = new ArrayList<>();
        while ((info=br.readLine())!=null){
            nameList.add(info);
        }
        br.close();
        Collections.shuffle(nameList);
        return nameList.get(0).split("-")[0];

    }


}

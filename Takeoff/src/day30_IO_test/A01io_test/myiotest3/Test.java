package day30_IO_test.A01io_test.myiotest3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
        /*需求：
            一个文件里面存储了班级同学的信息，格式为：张三-男-23
            每一个学生信息占一行。
            要求通过程序实现随机点名器。
            70%的概率随机到男生
            30%的概率随机到女生
            随机100万次，统计结果。看生成男生和女生的比例是不是接近于7：3
        */

        //1.读取数据，并把男生和女生的信息添加到不同的集合当中
        ArrayList<String> boyNameList = new ArrayList<>();
        ArrayList<String> girlNameList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("myiotest\\src\\com\\itheima\\myiotest3\\names.txt"));
        String line;
        while ((line = br.readLine()) != null){
            String[] arr = line.split("-");
            if(arr[1].equals("男")){
                boyNameList.add(line);
            }else{
                girlNameList.add(line);
            }
        }
        br.close();

        //2.定义权重集合，男女比例：7:3
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,1,1,1,1,1,1,0,0,0);

        //3.定义变量，统计被点到的次数
        int boyCount = 0;
        int girlCount = 0;

        Random r = new Random();

        //4.循环100万次
        for (int i = 0; i < 1000000; i++) {
           //5.从权重集合中获取随机数据
            int index = r.nextInt(list.size());
            int weight = list.get(index);
            //6.判断获取的随机数据是1还是0
            if(weight == 1){
                //1就随机男生
                Collections.shuffle(boyNameList);
                String boyInfo = boyNameList.get(0);
                System.out.println(boyInfo);
                boyCount++;
            }else{
                //0就随机女生
                Collections.shuffle(girlNameList);
                String girlInfo = girlNameList.get(0);
                System.out.println(girlInfo);
                girlCount++;
            }
        }

        System.out.println("随机抽取100万次，其中男生被抽到了" + boyCount);
        System.out.println("随机抽取100万次，其中女生被抽到了" + girlCount);

    }
}

package day30_IO_test.A01io_test.myiotest3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class tt3 {
    public static void main(String[] args) throws IOException {
                /*需求：
            一个文件里面存储了班级同学的信息，格式为：张三-男-23
            每一个学生信息占一行。
            要求通过程序实现随机点名器。
            70%的概率随机到男生
            30%的概率随机到女生
            随机100万次，统计结果。看生成男生和女生的比例是不是接近于7：3
        */
        File file = new File("Takeoff\\src\\day30\\A01io_test\\myiotest1\\info.txt");
        int boyCount = 0;
        int girlCount = 0;
        for (int i = 0; i < 1000; i++) {
            String result = dianming(file);
            if(result.split("-")[1].equals("男")){
                boyCount++;
            }else {
                girlCount++;
            }
        }
        System.out.println(boyCount/1000.0);
        //System.out.println(result);

    }

    private static String dianming(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String info;
        ArrayList<String> nameList = new ArrayList<>();
        String[] sex = {"男","男","男","男","男","男","男","女","女","女"};
        Random r = new Random();
        int sexN = r.nextInt(10);
        while ((info=br.readLine())!=null){
            nameList.add(info);
        }
        br.close();
        Collections.shuffle(nameList);

        return nameList.get(0).split("-")[1].equals(sex[sexN])?
                nameList.get(0):dianming(file);
    }
}

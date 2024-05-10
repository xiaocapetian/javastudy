package day28_IO.mytest;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class tt3 {
    public static void main(String[] args) throws IOException {
                /*
            文本文件中有以下的数据：    这题的关键在于想到sb啊 StringBuilder sb = new StringBuilder();
                2-1-9-4-7-8
            将文件中的数据进行排序，变成以下的数据：
                1-2-4-7-8-9
        */
        File file = new File("Takeoff\\src\\day28_IO\\mytest\\a.txt");
        File writefile = new File("Takeoff\\src\\day28_IO\\mytest\\awrite.txt");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(writefile);  //我怎么知道这题是字符流还是字节流啊!!!

        FileWriter fw = new FileWriter(writefile);


        int b;
        StringBuilder sb = new StringBuilder();
        while ((b=fis.read())!=-1){
            sb.append((char)b);
        }
        //System.out.println(sb);
        String[] str = sb.toString().split("-");
        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeSet<Integer> tree = new TreeSet<>();
        for (String s : str) {
            arrayList.add(Integer.parseInt(s));
            tree.add(Integer.parseInt(s));
        }
        System.out.println(arrayList);//[2, 1, 9, 4, 7, 8]
        System.out.println(tree);//[1, 2, 4, 7, 8, 9]
        Collections.sort(arrayList);
        System.out.println(arrayList);//[1, 2, 4, 7, 8, 9]
        for (int i = 0; i < arrayList.size(); i++) {
            if(i == arrayList.size()-1){
                fw.write(arrayList.get(i)+"");
                //fos.write(arrayList.get(i)+"");
            }
            else {
                fw.write(arrayList.get(i)+"-");
                //fos.write(arrayList.get(i)+"-");
            }
        }
        fw.close();
        fos.close();
        fis.close();




    }
}

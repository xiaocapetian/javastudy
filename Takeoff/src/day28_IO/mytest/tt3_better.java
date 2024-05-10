package day28_IO.mytest;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class tt3_better {
    /*
   文本文件中有以下的数据：    这题的关键在于想到sb啊 StringBuilder sb = new StringBuilder();
       2-1-9-4-7-8
   将文件中的数据进行排序，变成以下的数据：
       1-2-4-7-8-9
*/
    public static void main(String[] args) throws IOException {
        //1.读取数据
        FileReader fr = new FileReader("Takeoff\\src\\day28_IO\\mytest\\a.txt");
        File writefile = new File("Takeoff\\src\\day28_IO\\mytest\\awrite.txt");
        StringBuilder sb = new StringBuilder();
        int ch;
        while((ch = fr.read()) != -1){
            sb.append((char)ch);
        }
        fr.close();
        //System.out.println(sb);

        Integer[] arr = Arrays.stream(sb.toString()
                        .split("-"))
                .map(Integer::parseInt)  //  map的方法引用
                .sorted()
                .toArray(Integer[]::new); // toArroy的方法引用
                //System.out.println(Arrays.toString(arr));
        String s = Arrays.toString(arr).replace(", ", "-");
        String s1 = s.substring(1, s.length() - 1);

        FileWriter fw = new FileWriter(writefile);
        fw.write(s1);
        fw.close();
    }
}

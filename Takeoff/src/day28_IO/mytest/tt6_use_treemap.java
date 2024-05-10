package day28_IO.mytest;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class tt6_use_treemap {
    public static void main(String[] args) throws IOException {
                    /*
                需求：把《出师表》的文章顺序进行恢复到一个新文件中。
            */
        File file = new File("Takeoff\\src\\day28_IO\\mytest\\csb.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        while ((str = br.readLine())!=null){
            treeMap.put(Integer.parseInt(str.split("\\.")[0]),str.split("\\.")[1]);//后一个不要这么写,直接写全部内容就简单了
        }
        br.close();
        //System.out.println(treeMap);



        File file2 = new File("Takeoff\\src\\day28_IO\\mytest\\csb3.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        Set<Map.Entry<Integer, String>> entries = treeMap.entrySet();
        //System.out.println(entries);
        for (Map.Entry<Integer, String> entry : entries) {
            bw.write(entry.getKey()+"."+entry.getValue());//其实不需要这么麻烦
            bw.newLine();
        }
        bw.close();
    }
}

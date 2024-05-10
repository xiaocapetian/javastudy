package day28_IO.mytest;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class tt6_use_arraylist {
    public static void main(String[] args) throws IOException {
                    /*
                需求：把《出师表》的文章顺序进行恢复到一个新文件中。
            */
        File file = new File("Takeoff\\src\\day28_IO\\mytest\\csb.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        ArrayList<String> arrayList = new ArrayList<>();
        while ((str = br.readLine())!=null){
            arrayList.add(str);
        }
        br.close();
       //System.out.println(arrayList);
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1.split("\\.")[0])-Integer.parseInt(o2.split("\\.")[0]);
            }
        });
        //System.out.println(arrayList);
        File file2 = new File("Takeoff\\src\\day28_IO\\mytest\\csb2.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        for (String s : arrayList) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }
}

package day28_IO.A05myconvertstream;


import java.io.*;

public class ConvertStreamDemo4 {
    public static void main(String[] args) throws IOException {
        /*
            利用字节流读取文件中的数据，每次读一整行，而且不能出现乱码

            //1.字节流在读取中文的时候，是会出现乱码的，但是字符流可以搞定
            //2.字节流里面是没有读一整行的方法的，只有字符缓冲流才能搞定
        */

       /* FileInputStream fis = new FileInputStream("myio\\a.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        System.out.println(str);
        br.close();*/


        //把字节流FileInputStream 放进转换流InputStreamReader 然后就变成字符流的一种了,就可以放进字符缓冲流ufferedReader了
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("myio\\a.txt")));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();


    }
}

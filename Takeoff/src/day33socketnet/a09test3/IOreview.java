package day33socketnet.a09test3;

import java.io.*;

public class IOreview {
    public static void main(String[] args) throws IOException {
        File file = new File("");
        //字节流
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("");
        //字符流  只能操作纯文本文件
        FileReader fr = new FileReader("");
        FileWriter fw = new FileWriter("");
        //转换流
        InputStreamReader isr = new InputStreamReader(fis);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        //字符缓冲流,可以传进一个字符流,或者字节流的转换流
        BufferedReader br2 = new BufferedReader(fr);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw2 = new BufferedWriter(fw);
        BufferedWriter bw = new BufferedWriter(osw);
        //字节缓冲流
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

    }
}

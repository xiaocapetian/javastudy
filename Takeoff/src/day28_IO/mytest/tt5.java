package day28_IO.mytest;

import java.io.*;

public class tt5 {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\flanlin\\picture\\playboy\\pussy\\fanny\\SpankBang.com_porn_1080p.mp4");
        File filecopy = new File("E:\\flanlin\\picture\\playboy\\pussy\\fanny\\南京\\SpankBang.com_porn_1080p.mp4");
        //注意,这里输出的文件要写文件(哪怕不存在),不能写文件夹,否则报错

        //method1(file,filecopy);
        method2(file,filecopy);
        method3(file,filecopy);
        method4(file,filecopy);

        /*
        * method2: 63.91秒
          method3: 48.139秒
          method4: 5.167秒
        * */
    }
    public static void method1(File file,File filecopy) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(filecopy);
        int b;
        while ((b = fis.read())!=-1){
            fos.write(b);                    //一次读一个字节`
        }
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println("method1: "+(end-start)/1000.0+"秒");
    }
    public static void method2(File file,File filecopy) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(filecopy);
        byte[] bytes = new byte[1024*4];
        int len;
        while ((len = fis.read(bytes))!=-1){
            fos.write(bytes,0,len);           //一次读一个字节数组
        }
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println("method2: "+(end-start)/1000.0+"秒");
    }
    public static void method3(File file,File filecopy) throws IOException {
        long start = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filecopy));
        int b;
        while ((b=bis.read())!=-1){
            bos.write(b);
        }
        bos.close();
        bis.close();
        long end = System.currentTimeMillis();
        System.out.println("method3: "+(end-start)/1000.0+"秒");
    }
    public static void method4(File file,File filecopy) throws IOException {
        long start = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filecopy));
        int len;
        byte[] bytes = new byte[1024*4];
        while ((len = bis.read(bytes))!=-1){
            bos.write(bytes);
        }
        bos.close();
        bis.close();
        long end = System.currentTimeMillis();
        System.out.println("method4: "+(end-start)/1000.0+"秒");
    }
}

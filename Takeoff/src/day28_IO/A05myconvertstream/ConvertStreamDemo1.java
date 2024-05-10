package day28_IO.A05myconvertstream;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
            利用转换流按照指定字符编码读取(了解)

            因为JDK11：这种方式被淘汰了。替代方案(掌握)
            F:\JavaSE最新版\day29-IO（其他流）\资料\gbkfile.txt
        */

       /* //1.创建对象并指定字符编码   这段被下面的方法替代了,所以了解就行
        InputStreamReader isr = new InputStreamReader(new FileInputStream("myio\\gbkfile.txt"),"GBK");
        //2.读取数据
        int ch;
        while ((ch = isr.read()) != -1){
            System.out.print((char)ch);
        }
        //3.释放资源
        isr.close();*/


        FileReader fr = new FileReader("D:\\IdeaProjects\\javastudy\\Takeoff\\src\\day28_IO\\mytest\\gbkfile.txt", Charset.forName("GBK"));
        //2.读取数据
        int ch;
        while ((ch = fr.read()) != -1){
            System.out.print((char)ch);
        }
        //3.释放资源
        fr.close();




    }
}

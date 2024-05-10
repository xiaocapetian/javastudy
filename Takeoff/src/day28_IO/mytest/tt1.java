package day28_IO.mytest;

import java.io.*;

public class tt1 {
    public static void main(String[] args) throws IOException {
        //拷贝一个文件夹，考虑子文件夹

        //1.创建对象表示数据源
        File src = new File("E:\\flanlin\\history");
        //2.创建对象表示目的地
        File dest = new File("Takeoff\\src\\day28\\mytest\\aa");

        //3.调用方法开始拷贝
        copydir(src,dest);
    }

    private static void copydir(File src, File dest) throws IOException {
        dest.mkdir();//这个不能忘!!!
        File[] files = src.listFiles();
        for (File file : files) {
            if(file.isFile()){
                //是文件就要拷贝
                FileInputStream fis  = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest,file.getName()));
                byte[] bytes = new byte[1024];
                int len;
                while ((len = fis.read(bytes))!=-1){
                    fos.write(bytes,0,len);
                }

                fos.close();
                fis.close();
            }else {
                copydir(file,new File(dest,file.getName()));
            }
        }

    }
}

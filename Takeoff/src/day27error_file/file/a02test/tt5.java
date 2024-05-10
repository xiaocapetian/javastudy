package day27error_file.file.a02test;

import java.io.File;

public class tt5 {
    public static void main(String[] args) {
        File file = new File("E:\\flanlin\\picture\\playboy\\pussy\\fanny") ;
        long len = getlen(file);
        System.out.println(len);
        //System.out.println(len/1024/1024/1024);
    }
    public static long getlen(File file){
        File[] files = file.listFiles();
        long length = 0;
        for (File file1 : files) {
            if (file1.isDirectory()){
                length = length+getlen(file1);//!!!!!
                //本来写的是getlen(file1);  这样错了!!!1
            }else{
                length = length+file1.length();
            }
        }
        return  length;

    }
}

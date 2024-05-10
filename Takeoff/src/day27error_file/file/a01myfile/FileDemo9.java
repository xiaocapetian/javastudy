package day27error_file.file.a01myfile;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileDemo9 {
    public static void main(String[] args) {
         /*
        public File[] listFiles(FileFilter filter)      利用文件名过滤器获取当前该路径下所有内容
        public File[] listFiles(FilenameFilter filter)  利用文件名过滤器获取当前该路径下所有内容
      */

        //创建File对象
        File f = new File("E:\\flanlin\\history");
        //调用listFiles(FileFilter filter)
        File[] arr1 = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {

                return pathname.isFile() && pathname.getName().endsWith(".xlsx");
            }
        });
        System.out.println(Arrays.toString(arr1));
        System.out.println("=============");
        //调用listFiles(FilenameFilter filter)
        File[] arr2 = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //dir 父路径(上一级路径  name 子路径(文件名
                File src = new File(dir, name);
                return src.isFile() && name.endsWith(".xlsx");
            }
        });
        System.out.println(Arrays.toString(arr2));


    }
}

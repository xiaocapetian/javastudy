package day27error_file.file.a02test;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class tt2 {
    public static void main(String[] args) {
        File file = new File("E:\\flanlin\\picture\\playboy\\pussy\\fanny");

        System.out.println(havemp4(file));

    }
    public static boolean havemp4 (File file){
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".mp4");
                //return false;
            }
        });
        System.out.println(Arrays.toString(files));
        if(files.length!=0)return true;
        else {
        return false;}
    }

}

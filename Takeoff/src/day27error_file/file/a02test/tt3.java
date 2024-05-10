package day27error_file.file.a02test;

import java.io.File;
import java.util.ArrayList;

public class tt3 {

    public static void main(String[] args) {
        //File[] myav = new File[0];
        ArrayList<File> myav = new ArrayList<>();
        File src = new File("E:\\");
        getav(src,myav);
        System.out.println(myav);
    }
    public static void getav (File file,ArrayList<File> myav){
        File[] files = file.listFiles();
        if(files!=null){
            for (File file1 : files) {
                if(file1.isDirectory()){
                    getav(file1,myav);
                }
                else if(file1.isFile()&&file1.getName().endsWith(".mp4")){
                    //myav.add(file1);
                    System.out.println(file1);
                }
            }
        }


    }
}

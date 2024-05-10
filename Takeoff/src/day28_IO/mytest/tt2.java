package day28_IO.mytest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class tt2 {
    public static void main(String[] args) throws IOException {
        File originalpic = new File("Takeoff\\src\\day28\\mytest\\微信图片_20231218135654.jpg");
        File jiamipic = new File("Takeoff\\src\\day28\\mytest\\5654.jpg");
        File jiemipic = new File("Takeoff\\src\\day28\\mytest\\5655.jpg");


        //encryption(originalpic,jiamipic);//加密
        encryption(jiamipic,jiemipic);//解密
    }

    private static void encryption(File originalpic, File jiamipic) throws IOException {
        FileInputStream fis = new FileInputStream(originalpic);
        FileOutputStream fos = new FileOutputStream(jiamipic);
        int b;
        while ((b=fis.read())!=-1){
            fos.write(b^2);
        }
        fos.close();
        fis.close();
    }

}

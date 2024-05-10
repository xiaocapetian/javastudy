package day27error_file.file.a02test;

import java.io.File;
import java.io.IOException;

public class tt1 {
    public static void main(String[] args) throws IOException {
        String path = "Takeoff\\src\\day27error_file\\aaa\\c";
        File file1 = new File(path);
        File file2 = new File("Takeoff\\src\\day27error_file\\aaa\\c.txt");
        boolean newFile = file2.createNewFile();
        file1.mkdir();
        File file3 = new File(file1,"d.txt");
        file3.createNewFile();
    }
}

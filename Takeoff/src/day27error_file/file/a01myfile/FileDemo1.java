package day27error_file.file.a01myfile;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
    /*
        public File(String pathname)                根据文件路径创建文件对象---不再是字符串了,而变成了真实能操作的文件
        当然这个路径可以是存在的也可以是不存在的
        public File(String parent, String child)    根据父路径名字符串和子路径名字符串创建文件对象
        public File(File  parent, String child)     根据父路径对应文件对象和子路径名字符串创建文件对象

        C:\Users\alienware\Desktop

        \:转移字符

        注意windows系统分隔符是\
        linux系统分隔符是/
    */



        //1.根据字符串表示的路径，变成File对象
        String str = "C:\\Users\\alienware\\Desktop\\a.txt";
        File f1 = new File(str);
        System.out.println(f1);//C:\Users\alienware\Desktop\a.txt

        //2.父级路径：C:\Users\alienware\Desktop
        //子级路径：a.txt
        String parent = "C:\\Users\\alienware\\Desktop";
        String child = "a.txt";
        File f2 = new File(parent,child);
        System.out.println(f2);//C:\Users\alienware\Desktop\a.txt

        File f3 = new File(parent + "\\" + child);
        System.out.println(f3);//C:\Users\alienware\Desktop\a.txt


        //3.把一个File表示的路径和String表示路径进行拼接
        File parent2 = new File("C:\\Users\\alienware\\Desktop");
        String child2 = "a.txt";
        File f4 = new File(parent2,child2);
        System.out.println(f4);//C:\Users\alienware\Desktop\a.txt


    }
}
package day28_IO.mytest;

import java.io.*;

public class tt7 {
    public static void main(String[] args) throws IOException {
                        /*
                实现一个验证程序运行次数的小程序，要求如下：
                1.当程序运行超过3次时给出提示:本软件只能免费使用3次,欢迎您注册会员后继续使用~
                2.程序运行演示如下:
                    第一次运行控制台输出: 欢迎使用本软件,第1次使用免费~
                    第二次运行控制台输出: 欢迎使用本软件,第2次使用免费~
                    第三次运行控制台输出: 欢迎使用本软件,第3次使用免费~
                    第四次及之后运行控制台输出:本软件只能免费使用3次,欢迎您注册会员后继续使用~
这题我用的是FileReader,比较麻烦,不好,也只能读一位
           */
        useapp();
        useapp();
        useapp();
        useapp();
        useapp();
        useapp();

    }
    public static void useapp() throws IOException {
        File file = new File("D:\\IdeaProjects\\javastudy\\Takeoff\\src\\day28_IO\\mytest\\tt7.txt");
        FileReader fr = new FileReader(file);

        //char[] chars = new char[10];
        //StringBuilder sb = new StringBuilder();
        int i;


        if ((i = fr.read()) != -1) {
            System.out.println("i="+(char)i);
            if (i-48 <= 2) {
                i++;
                System.out.println("欢迎使用本软件,第" + (i-48) + "次使用免费~");
                FileWriter fw = new FileWriter("D:\\IdeaProjects\\javastudy\\Takeoff\\src\\day28_IO\\mytest\\tt7.txt");
                fw.write(i-48+"");
                fw.close();
            } else {
                System.out.println("本软件只能免费使用3次,欢迎您注册会员后继续使用~");
            }
        } else {
            System.out.println("欢迎使用本软件,第1次使用免费~");
            FileWriter fw = new FileWriter("D:\\IdeaProjects\\javastudy\\Takeoff\\src\\day28_IO\\mytest\\tt7.txt");
            fw.write("1");
            fw.close();
        }

       fr.close();
    }
    }
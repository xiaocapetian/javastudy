package day28_IO.mytest;

import java.io.*;

public class tt7_better { //使用BufferedReader好用多了,,,

    /*
实现一个验证程序运行次数的小程序，要求如下：
1.当程序运行超过3次时给出提示:本软件只能免费使用3次,欢迎您注册会员后继续使用~
2.程序运行演示如下:
第一次运行控制台输出: 欢迎使用本软件,第1次使用免费~
第二次运行控制台输出: 欢迎使用本软件,第2次使用免费~
第三次运行控制台输出: 欢迎使用本软件,第3次使用免费~
第四次及之后运行控制台输出:本软件只能免费使用3次,欢迎您注册会员后继续使用~
*/
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\IdeaProjects\\javastudy\\Takeoff\\src\\day28_IO\\mytest\\tt7.txt");

        BufferedReader br = new BufferedReader(new FileReader(file) );
        //char[] chars = new char[10];
        //StringBuilder sb = new StringBuilder();
        int i;
        String strcount = br.readLine();
        int count = Integer.parseInt(strcount);
        br.close();
        count++;//1
        //2.判断
        if(count <= 3){
            System.out.println("欢迎使用本软件,第"+count+"次使用免费~");
        }else{
            System.out.println("本软件只能免费使用3次,欢迎您注册会员后继续使用~");
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(count+"");
        bw.close();


    }
}

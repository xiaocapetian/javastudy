package day30_IO_test.A01io_test.myiotest8;


import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
       /*
        需求：写一个登陆小案例（添加锁定账号功能）

        步骤：
        	将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
        	保存格式为:username=zhangsan&password=123&count=0
        	让用户键盘录入用户名和密码
        	比较用户录入的和正确的用户名密码是否一致
        	如果一致则打印登陆成功
        	如果不一致则打印登陆失败，连续输错三次被锁定

        */

        //1.读取正确的用户名和密码
        BufferedReader br = new BufferedReader(new FileReader("myiotest\\src\\com\\itheima\\myiotest8\\userinfo.txt"));
        String line = br.readLine();//username=zhangsan&password=123&count=0
        br.close();
        String[] userInfo = line.split("&");
        String[] arr1 = userInfo[0].split("=");
        String[] arr2 = userInfo[1].split("=");
        String[] arr3 = userInfo[2].split("=");

        String rightUsername = arr1[1];
        String rightPassword = arr2[1];
        //count:表示用户连续输错的次数
        int count = Integer.parseInt(arr3[1]);

        //2.用户键盘录入用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        //3.比较
        if (rightUsername.equals(username) && rightPassword.equals(password) && count < 3) {
            System.out.println("登陆成功");
            writeInfo("username=" + rightUsername + "&password=" + rightPassword + "&count=0");
        } else {
            count++;
            if (count < 3) {
                System.out.println("登陆失败,还剩下" + (3 - count) + "次机会");
            } else {
                System.out.println("用户账户被锁定");
            }

            writeInfo("username=" + rightUsername + "&password=" + rightPassword + "&count=" + count);
        }
    }

    /*
    * 作用：
    *       写出一个字符串到本地文件中
    * 参数：
    *       要写出的字符串
    * */
    public static void writeInfo(String content) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("myiotest\\src\\com\\itheima\\myiotest8\\userinfo.txt"));
        bw.write(content);
        bw.close();
    }
}
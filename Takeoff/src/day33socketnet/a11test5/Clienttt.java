package day33socketnet.a11test5;

import java.io.*;
import java.net.Socket;

public class Clienttt {
    public static void main(String[] args) throws IOException {
        //客户端：将本地文件上传到服务器。接收服务器的反馈。
        //服务器：接收客户端上传的文件，上传完毕之后给出反馈。

        //[1]第一步要想什么,先连上
        Socket socket = new Socket("127.0.0.1",10001);
        File file = new File("E:\\flanlin\\picture\\playboy\\pussy\\fanny\\南京\\微信图片_20231218135654.jpg");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos  = new BufferedOutputStream(socket.getOutputStream());

        //要快速传递,就别一个字节一个字节了,用字节数组啊!
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }

        //bis.close();
        socket.shutdownOutput();

        //等着接受反馈
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = br.readLine();
        System.out.println(result);
    }
}

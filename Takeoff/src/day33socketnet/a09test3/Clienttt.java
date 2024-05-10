package day33socketnet.a09test3;

import java.io.*;
import java.net.Socket;

public class Clienttt {
    public static void main(String[] args) throws IOException {
        //客户端：将本地文件上传到服务器。接收服务器的反馈。
        //服务器：接收客户端上传的文件，上传完毕之后给出反馈。

        Socket socket = new Socket("127.0.0.1",10001);
        //图片,word非纯文本文件是可以的   【我发现老师写的也不能传纯文本文件】
        //File file = new File("E:\\文献\\【001】用于3D医学图像分割的Transformer.docx");
        File file = new File("E:\\flanlin\\picture\\playboy\\pussy\\fanny\\南京\\微信图片_20231218135654.jpg");
        //反而是txt,md纯文本文件不行
        //File file = new File("G:\\我的云端硬盘\\守护我\\【006】python学习笔记.md");
        //File file = new File("G:\\我的云端硬盘\\守护我\\路径.txt");


        /* 自己写的,但是这样不好,不如老师写的

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        int b;
        StringBuilder sb = new StringBuilder();
        while ((b = br.read())!=-1){
            //System.out.print((char) b);
            sb.append((char) b);
        }
        System.out.println("读取本地文件完毕,准备传输");
        //读取了存在sb,然后可以开始了传输了吧
        OutputStream os = socket.getOutputStream();
        os.write(sb.toString().getBytes(StandardCharsets.UTF_8));
        System.out.println("传输完毕,准备接收反馈");

        */
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        //结束标记
        socket.shutdownOutput();

        //接受服务器的反馈
        BufferedReader br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br2.readLine();
        System.out.println(s);
        /*自己写的,但是这样太麻烦了,因为反馈只有一行
        int b2;
        StringBuilder sb2 = new StringBuilder();
        while ((b2=br2.read())!=-1){
            sb2.append((char)b2);
            //System.out.print((char)b);
            System.out.println("反馈正在录入,请稍后");
        }
        System.out.println("反馈录入完毕,准备打印");
        System.out.println(sb2);

         */
        socket.close();

    }
}

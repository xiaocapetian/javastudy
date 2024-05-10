package day33socketnet.a09test3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servertt2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);
        Socket socket = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int b;
        StringBuilder sb = new StringBuilder();
        System.out.println("服务器开始录入了!");
        while ((b=br.read())!=-1){
            sb.append((char)b);
            //System.out.print((char)b);
        }
        System.out.println("服务器走出while循环");

        System.out.println(sb);

        File file = new File("D:\\路径.txt");
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();
        //
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("已经收到了");
        bw.newLine();
        bw.flush();//bw.flush() 的作用是将缓冲区的内容立即写入底层输出流，即强制将缓冲区中的数据发送到目的地
        // （这里是 socket.getOutputStream()）。在使用缓冲流时，写入的数据通常会先存储在缓冲区中，并不会立即写入底层流，
        // 而是等到缓冲区满了、手动调用 flush()、关闭流时才会将数据真正写入底层流。

        socket.close();
        ss.close();
    }
}

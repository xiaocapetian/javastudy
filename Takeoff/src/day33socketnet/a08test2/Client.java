package day33socketnet.a08test2;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端：发送一条数据，接收服务端反馈的消息并打印
        //服务器：接收数据并打印，再给客户端反馈消息



        //1.创建Socket对象并连接服务端
        Socket socket = new Socket("127.0.0.1",10001);


        //2.写出数据
        String str = "见到你很高兴！";
        OutputStream os = socket.getOutputStream();
        os.write(str.getBytes());

        //写出一个结束标记
        socket.shutdownOutput();


        //3.接收服务端回写的数据
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int b = 0;
        StringBuilder sb = new StringBuilder();
        while (b!=-2&&(b = isr.read())!=-1){
            char c = (char) b;
            sb.append(c);
            if (c == '\n') {
                // 检测到换行符，表示一条消息结束
                System.out.println(sb.toString());
                sb.setLength(0);  // 重置StringBuilder，准备接收下一条消息
                b = -2;
            }

        }


        //释放资源
        socket.close();


    }
}
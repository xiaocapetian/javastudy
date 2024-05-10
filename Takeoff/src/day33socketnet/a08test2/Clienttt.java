package day33socketnet.a08test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Clienttt {
    public static void main(String[] args) throws IOException {
        //客户端发消息
        //客户端：发送一条数据，接收服务端反馈的消息并打印
        //服务器：接收数据并打印，再给客户端反馈消息
        Socket socket = new Socket("127.0.0.1",10001);
        OutputStream os = socket.getOutputStream();
        String str = "和你一起玩很高兴!\n";
        os.write(str.getBytes());
        //必须要加这个↓,否则服务器一直等客户端继续发,但是关了之后就不能重新打开了,socket也不能再次获得getOutputStream()了
        //socket.shutdownOutput();
        //如果不想加这个,
        /*
        * 在Java的网络编程中，br.read() 会阻塞直到有数据可读，或者返回 -1 表示输入流已经结束。
        * 所以，要使服务器的 (b = br.read()) 等于 -1，需要满足以下条件之一：
           客户端关闭连接：当客户端关闭连接时，服务器端的 read() 方法可能返回 -1。
           客户端发送一个特定的结束标志：在消息的最后添加一个特定的标志，服务器端通过检测这个标志知道消息已经结束。*/

        //收服务器的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int b = 0;
        StringBuilder sb = new StringBuilder();
        while (b!=-2&&(b = br.read())!=-1){
            char c = (char) b;
            sb.append(c);
            if (c == '\n') {
                // 检测到换行符，表示一条消息结束
                System.out.println(sb);
                sb.setLength(0);  // 重置StringBuilder，准备接收下一条消息
                b = -2;
            }

        }


        String str2 = "像那个晚上一样开心!\n";
        os.write(str2.getBytes());

        socket.close();
    }
}

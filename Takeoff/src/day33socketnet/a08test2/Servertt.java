package day33socketnet.a08test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Servertt {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10001);
        Socket socket = serverSocket.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        int b = 0;
        StringBuilder sb = new StringBuilder();
        while (b!=-2&&(b = br.read())!=-1){
            char c = (char) b;
            sb.append(c);
            if (c == '\n') {
                // 检测到换行符，表示一条消息结束
                System.out.println(sb.toString());
                sb.setLength(0);  // 重置StringBuilder，准备接收下一条消息
                b = -2;
            }

        }
        OutputStream os = socket.getOutputStream();
        os.write("到底有多开心?\n".getBytes(StandardCharsets.UTF_8));

        while ((b = br.read())!=-1){
            System.out.print((char)b);
        }

        //br.close();
        socket.close();
        serverSocket.close();

    }
}

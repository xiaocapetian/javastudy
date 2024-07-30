package net_4_1_4_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 这是一个简单的 TCP 客户端示例
 */
public class Client {
    public static void main(String[] args) {
        boolean keepAlive = false; // 是否启用HTTP Keep-Alive
        // 尝试连接到服务器的 IP 地址和端口号 8080
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            //new Socket("127.0.0.1", 8080): 当你调用 new Socket 时，Java 会自动执行三次握手过程。
            // 在这个过程中，客户端会发送 SYN 包，服务端会响应 SYN+ACK 包，客户端最终会发送 ACK 包。你不会在代码中看到这些操作，但它们在后台自动完成。
            // 一旦连接成功，客户端的 Socket 对象会被创建，并与服务端建立 TCP 连接

            System.out.println("Connected to server: " + socket.getInetAddress());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 发送 HTTP 请求头
            writer.println("GET / HTTP/1.1");
            writer.println("Host: 127.0.0.1");
            if (keepAlive) {
                writer.println("Connection: keep-alive");
            } else {
                writer.println("Connection: close");
            }
            writer.println();
            writer.flush();

            // 发送消息到服务器
            writer.println("很高兴见到你");
            writer.flush();

            // 读取 HTTP 响应
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.isEmpty()) {
                    break;
                }
            }

            // 读取服务器的额外消息
            String serverMessage = reader.readLine();
            System.out.println("从服务器收到的消息: " + serverMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

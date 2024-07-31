package net_4_1_4_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这是一个简单的 TCP 服务器示例
 */
public class Server {
    public static void main(String[] args) {
        // 创建一个 ServerSocket 监听端口 8080
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

           // 无限循环，持续监听并处理客户端连接
            while (true) {
                System.out.println("持续监听并处理客户端连接...");
                // 这就是三次握手中的第三次握手，即服务端在等待客户端的 ACK 包
                // 接受客户端连接
                try (Socket socket = serverSocket.accept()) {// 这里会阻塞，等待直到客户端连接到达
                    // 一旦连接建立成功，ServerSocket 的 accept() 方法会返回一个 Socket 对象
                    System.out.println("Client connected: " + socket.getInetAddress());
                    //serverSocket.accept(): 当你调用 accept() 方法时，服务端会等待并接收来自客户端的连接请求。在此过程中，服务端会接收到客户端的 SYN 包，并发送 SYN+ACK 包。
                    // 服务端在接收到客户端的 ACK 包后，accept() 方法会返回一个 Socket 对象，表示连接已经建立。
                    // 处理客户端请求
                    handleRequest(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 处理客户端请求
     * @param socket 连接的 Socket
     */
    private static void handleRequest(Socket socket) throws IOException {
        // 创建读取器 reader 从客户端读取输入
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 创建写入器 writer 向客户端发送输出
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        // 读取客户端发送的请求内容
        String clientMessage = reader.readLine();
        System.out.println("收到客户端消息: " + clientMessage);

        // 发送响应内容
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/plain");
        writer.println("Content-Length: 17");
        writer.println("Connection: close");
        writer.println(); // 空行结束 HTTP 头
        writer.println("到底有多开心？"); // 响应内容

        // 关闭连接
        socket.close();
    }
}
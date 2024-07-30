package net4_1_3_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
    public static void main(String[] args) {
        // 创建一个ServerSocket监听8080端口
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");
            // 无限循环，持续监听并处理客户端连接
/*            while (true) {
                System.out.println("持续监听并处理客户端连接...");
                // 接受客户端连接
                //为什么要这么写啊? Socket 会在 try-with-resources 块结束时自动关闭。
                // 这样可以确保每次处理完一个客户端请求后，Socket 资源都会被释放，避免资源泄漏。
                try (Socket socket = serverSocket.accept()) {

                    // 处理客户端请求
                    handleRequest(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
            while (true) {
                // 接受客户端连接
                Socket socket = serverSocket.accept();
                try {
                    // 处理客户端请求
                    handleRequest(socket);
                } finally {
                    System.out.println("让我看看连接关闭了没?"+(socket.isClosed()?"关了":"没关"));
                    // 手动关闭连接，除非客户端保持连接
                    if (socket != null && !socket.isClosed()) {
                        System.out.println("Socket is about to close: " + socket);
                        try {
                            socket.close();
                            System.out.println("现在我得关掉了 " + socket.isClosed());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理客户端请求
     * @param socket
     */
    private static void handleRequest(Socket socket) throws IOException {
        // 创建读取器reader从客户端读取输入
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 创建写入器向客户端发送输出
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        String line;
        // 默认保持连接
        boolean keepAlive = true;

        // Read HTTP request 读取HTTP请求头
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            // 打印请求行
            System.out.println(line);
            // 如果客户端要求关闭连接
            if (line.equalsIgnoreCase("Connection: close")) {
                System.out.println("客户端要求关闭连接");
                // 设置为不保持连接
                keepAlive = false;
            }
        }

        // Read the message from the client
        String clientMessage = reader.readLine();
        System.out.println("我收到了客户端的话: " + clientMessage);

        // Send HTTP response 发送HTTP响应头
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/plain");
        writer.println("Content-Length: 13");
        if (keepAlive) {
            // 如果,保持连接
            writer.println("Connection: keep-alive");
        } else {
            //否则关闭连接
            writer.println("Connection: close");
        }
        writer.println();// 空行结束HTTP头
        writer.println("到底有多开心?");// 响应内容

        // Decide whether to close the connection
        //如果 , 关闭连接
        if (!keepAlive) {
            socket.close();
        }
        //System.out.println("让我看看连接关闭了没? Socket closed: " + socket.isClosed());
    }
}

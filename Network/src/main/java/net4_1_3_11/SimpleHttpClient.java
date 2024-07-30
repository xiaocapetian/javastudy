package net4_1_3_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端
 */
public class SimpleHttpClient {
    public static void main(String[] args) {
        //boolean keepAlive = false; // 是否启用HTTP Keep-Alive
        boolean keepAlive = true;
        // 连接到服务器
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send HTTP request // 发送HTTP请求头
            writer.println("GET / HTTP/1.1");
            writer.println("Host: 127.0.0.1");
            System.out.println("我要求客户端关闭连接:"+!keepAlive);
            if (keepAlive) {
                writer.println("Connection: keep-alive");
            } else {
                writer.println("Connection: close");
            }
            writer.println();
            writer.flush();

            // Send a message to the server
            writer.println("很高兴见到你");
            writer.flush();

            // Read HTTP response
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.isEmpty()) {
                    break;
                }
            }
            // Read the additional message from the server
            String serverMessage = reader.readLine();
            System.out.println("Received from server(我收到了服务端的话): " + serverMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

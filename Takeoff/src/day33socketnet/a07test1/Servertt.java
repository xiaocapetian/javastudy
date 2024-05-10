package day33socketnet.a07test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servertt {
    public static void main(String[] args) throws IOException {
        //服务器接受数据
        ServerSocket serverSocket = new ServerSocket(10001);//接受数据先建一个serverSocket,里面放端口
        Socket socket = serverSocket.accept();//再把这个serverSocket的accept,给新建的socket
        //这里.accept()的意思是等待客户端来连接,直到有连接的,才把客户端给socket

        //下面写IO的了
        int b;
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //str = "";
        //StringBuilder sb = new StringBuilder();
        while ((b = br.read()) != -1) {
                //sb.append((char) b);
            System.out.print((char)b);
            }
        //str = sb.toString();
        //System.out.println(str);

        //释放资源
        socket.close();
        serverSocket.close();


    }
}

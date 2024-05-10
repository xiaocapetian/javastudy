package day33socketnet.a07test1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//客户端：多次发送数据
//服务器：接收多次接收数据，并打印
public class Clienttt {
    public static void main(String[] args) throws IOException {
        //客户端，发送数据
        //指定往谁发送数据?
        Socket socket = new Socket("127.0.0.1",10001);//发送数据要建一个socket,传进去要发到的端口和地址
        //2.可以从连接通道中获取输出流
        OutputStream os = socket.getOutputStream();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("你要发:");
            String s = sc.nextLine();
            os.write(s.getBytes(StandardCharsets.UTF_8));
            if(s.equals("886")){
                break;
            }
        }
        os.close();
        socket.close();


    }
}

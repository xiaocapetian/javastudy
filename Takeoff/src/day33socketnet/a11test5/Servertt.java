package day33socketnet.a11test5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servertt {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        while (true) {
            Socket socket = ss.accept();
            new Thread(new Runtt(socket)).start();
            //5.释放资源
            //socket.close();//用多线程的话就不能在这里close了,得在线程里close
        }

        //服务器不要关,不停的等收到用户发的东西
        //ss.close();

    }
}

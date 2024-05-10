package day33socketnet.a02udpdemo1;


import java.io.IOException;
import java.net.*;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        //发送数据


        //1.创建DatagramSocket对象(快递公司)
        //细节：
        //绑定端口，以后我们就是通过这个端口往外发送
        //空参：所有可用的端口中随机一个进行使用
        //有参：指定端口号进行绑定
        DatagramSocket ds = new DatagramSocket();//什么端口发出去不重要，发到哪个端口才重要！

        //2.打包数据
        String str = "你好威啊！！！";
        byte[] bytes = str.getBytes();
        //InetAddress address = InetAddress.getByName("127.0.0.1");
        InetAddress address = InetAddress.getByName("LAPTOP-0J457R83");
        int port = 10086;//发到那个端口，那接收端也要用这个端口来接收

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

        //3.发送数据
        ds.send(dp);


        //4.释放资源
        ds.close();


    }
}

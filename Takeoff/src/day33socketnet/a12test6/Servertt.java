package day33socketnet.a12test6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Servertt {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        //创建线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                //记住,这里面最多有7个参数
                3,//核心core pool size
                6,//max pool size
                60,//keepAlive存活
                TimeUnit.SECONDS,//time unit时间单位
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),//线程工厂
                new ThreadPoolExecutor.AbortPolicy()//阻塞队列
        );
        while (true) {
            Socket socket = ss.accept();
            //new Thread(new Runtt(socket)).start();

            pool.submit(new Runtt(socket));
        }

        //服务器不要关,不停的等收到用户发的东西
        //ss.close();

    }
}

package day31thread.a14waitandnotify;

import java.util.concurrent.ArrayBlockingQueue;

public class tt {
    public static void main(String[] args) {
        /*
         *
         *    需求：利用阻塞队列完成生产者和消费者（等待唤醒机制）的代码
         *    细节：
         *           生产者和消费者必须使用同一个阻塞队列
         *
         * */
        ArrayBlockingQueue<String> abqueue = new ArrayBlockingQueue<>(3);
                //泛型表示的是数据的类型
        Cooktt cook = new Cooktt(abqueue);
        Foodiett foodiett = new Foodiett(abqueue);

        cook.start();
        foodiett.start();
    }
}

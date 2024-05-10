package day31thread.a14waitandnotify;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodiett extends Thread{
    ArrayBlockingQueue<String> queue;

    public Foodiett(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                String take = queue.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

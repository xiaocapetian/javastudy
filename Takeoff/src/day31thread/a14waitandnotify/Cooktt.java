package day31thread.a14waitandnotify;

import java.util.concurrent.ArrayBlockingQueue;

public class Cooktt extends Thread{
    ArrayBlockingQueue<String> queue;

    public Cooktt(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                queue.put("面条");
                System.out.println("厨师放了一碗面条");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

package day31thread.a02threadcase2;

public class runss2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName()+"qq");
        }
    }
}

package day31thread.a09threadsafe1;

public class runtt9 implements Runnable {
    int tickets = 1;

    @Override
    public void run() {
        while (tickets<=100){
            synchronized (runtt9.class){
            System.out.println("售票员"+Thread.currentThread().getName()+"把第"+tickets+"张票售出了");
            tickets++;
        }//这种写法就会导致卖了101,102票,因为锁没有锁while (tickets<=100){  这里,
            //也就是说,锁要在循环的外面,但是判断要在锁的里面
        }
    }
}

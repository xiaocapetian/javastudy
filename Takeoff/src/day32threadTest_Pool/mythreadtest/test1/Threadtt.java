package day32threadTest_Pool.mythreadtest.test1;

public class Threadtt extends Thread{
    static int tickets = 1000;

    @Override
    public void run() {
        while (true){synchronized (Threadtt.class){
            if (tickets>0){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickets--;
                System.out.println(getName()+"在买票,还剩下"+tickets+"张电影票");
            }else {
                break;
            }
        }}

    }
}

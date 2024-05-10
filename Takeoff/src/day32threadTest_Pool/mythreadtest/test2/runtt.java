package day32threadTest_Pool.mythreadtest.test2;

public class runtt implements Runnable{
    static int gift = 100;

    @Override
    public void run() {
        while (true){
            synchronized (runtt.class){
                if(gift<=10){
                    System.out.println("礼物还剩下" + gift + "不再赠送");
                    break;}
                else {
                    gift--;
                    System.out.println(Thread.currentThread().getName()+"送礼物,还剩"+gift+"个");
                }
            }
        }

    }
}

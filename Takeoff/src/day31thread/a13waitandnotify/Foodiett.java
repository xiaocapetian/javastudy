package day31thread.a13waitandnotify;

public class Foodiett extends Thread{
    @Override
    public void run() {
        //
        while (true){
            //枷锁
            synchronized (Desktt.lock){
                //别慌看有没有面条,先看有没有吃饱
                if(Desktt.count==0){
                    break;
                }else {
                    if (Desktt.foodFlag == 1) {
                        //有面条
                        Desktt.count--;
                        System.out.println("毛泽东干掉了一个右派,还要再打倒" + Desktt.count + "个右派");
                        Desktt.foodFlag = 0;
                        //唤醒厨师
                        Desktt.lock.notifyAll();
                    }else {//没有面条
                        try {
                            Desktt.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

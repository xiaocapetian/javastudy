package day31thread.a09threadsafe1;

public class MyThread extends Thread {

    //表示这个类所有的对象，都共享ticket数据
    static int ticket = 0;//0 ~ 99

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {//锁起来,锁对象唯一,如果没有这个锁,就会出现卖同一张票
                //同步代码块
                if (ticket < 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票！！！");
                } else {
                    break;
                }
            }
        }

    }



}

package day31thread.a13waitandnotify;

public class Cooktt extends Thread{
    @Override
    public void run() {
        //循环
        while (true){
            //加锁
            synchronized (Desktt.lock){
                if(Desktt.count==0){break;}
                else {
                    if(Desktt.foodFlag==1){
                        try {
                            Desktt.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("群众推荐了一名右派");
                        Desktt.foodFlag = 1;
                        //做好面条之后要等待
                        Desktt.lock.notifyAll();
                    }
                }
            }
        }
    }
}

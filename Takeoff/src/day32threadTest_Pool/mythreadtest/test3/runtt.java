package day32threadTest_Pool.mythreadtest.test3;

public class runtt implements Runnable{
    int num = 0;
    @Override
    public void run() {
        while (true){
            synchronized (runtt.class){
                if (num<=100){
                    if (num%2==1){
                        System.out.println(Thread.currentThread().getName()+"打印数字1"+num);
                    }
                }
                else {
                    break;
                }
                num++;
            }
        }
    }
}

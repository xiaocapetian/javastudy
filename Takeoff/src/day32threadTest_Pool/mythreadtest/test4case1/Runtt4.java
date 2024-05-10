package day32threadTest_Pool.mythreadtest.test4case1;

import java.util.Random;

public class Runtt4 implements Runnable{
    //共享数据
    //100块，分成了3个包
    static double money = 100;
    static int count = 3;

    //最小的中奖金额
    static final double MIN = 0.01;

    @Override
    public void run() {
        Random r = new Random();
        synchronized (Runtt4.class){
        if(count<=0){
            System.out.println(Thread.currentThread().getName()+"没抢到红包");
        }else if(count == 1){
            System.out.println(Thread.currentThread().getName()+"抢到了"+money+"元");
            count--;
        }
        else {

            double price = r.nextDouble(money-(count-1)*MIN);
            if(price<MIN){
                price = MIN;
            }
            System.out.println(Thread.currentThread().getName()+"抢到了"+price+"元");
            count--;
            money = money-price;
        }
        }
    }
}

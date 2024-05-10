package day32threadTest_Pool.mythreadtest.test5;

import java.util.ArrayList;
import java.util.Random;

public class runtt5 implements Runnable{
    static public int count = 0;
    ArrayList<Integer> arrayList;

    public runtt5(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true){
            synchronized (runtt5.class){
                if (arrayList.isEmpty()){
                    break;
                }else {
                    //Collections.shuffle(list);忘了打乱顺序了
                    int num = r.nextInt(arrayList.size());
                    System.out.println(Thread.currentThread().getName()+"又发动了涉及"+arrayList.get(num)+"人的大清洗");
                    arrayList.remove(num);
                }
            }
            try {
                Thread.sleep(10);  //加这个睡觉,主要是为了显示,因为数据太小,不睡觉一个线程就抢完了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

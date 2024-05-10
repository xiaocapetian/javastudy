package day32threadTest_Pool.mythreadtest.test6case1;

import day32threadTest_Pool.mythreadtest.test5.runtt5;

import java.util.ArrayList;
import java.util.Collections;

public class runtt6 implements Runnable{
    static public int count = 0;
    ArrayList<Integer> arrayList;

    public runtt6(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        ArrayList<Integer> menu = new ArrayList<>();//我这么写才是正确的
        while (true){
            synchronized (runtt5.class){
                if (arrayList.isEmpty()){
                    break;
                }else {
                    Collections.shuffle(arrayList);
                    Integer removed = arrayList.remove(0);
                    menu.add(removed);
                }
            }
            try {
                Thread.sleep(10);  //加这个睡觉,主要是为了显示,因为数据太小,不睡觉一个线程就抢完了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int max = menu.get(0);
        int sum = 0;
        int ci = 0;
        for (int num : menu) {
            if (num > max) {
                max = num;
            }
            sum += num;
            ci++;
        }


        System.out.println("在此次清理阶级队伍运动的会议上,"+Thread.currentThread().getName()+"共编造了"+ci+
                "次冤假错案,分别涉及人数为"+menu.toString()+
                "最多的一次涉及人数为"+max+"总人数为"+sum);


    }
}

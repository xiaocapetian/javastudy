package day32threadTest_Pool.mythreadtest.test5;

import java.util.ArrayList;
import java.util.Collections;

public class tt5 {
    public static void main(String[] args) {
                /*
            有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池中的奖项为 {10,5,20,50,100,200,500,800,2,80,300,700};
            创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”
            随机从抽奖池中获取奖项元素并打印在控制台上,格式如下:
                             每次抽出一个奖项就打印一个(随机)
            	抽奖箱1 又产生了一个 10 元大奖
            	抽奖箱1 又产生了一个 100 元大奖
            	抽奖箱1 又产生了一个 200 元大奖
            	抽奖箱1 又产生了一个 800 元大奖
            	抽奖箱2 又产生了一个 700 元大奖
            	.....
        */
        ArrayList<Integer> arrayList = new ArrayList<>();
        Integer[] pool = {10,5,20,50,100,200,500,800,2,80,300,700};
        Collections.addAll(arrayList,pool);
        //Threadtt5 t1 = new Threadtt5(arrayList);
        //Threadtt5 t2 = new Threadtt5(arrayList);
        runtt5 run = new runtt5(arrayList);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        t1.setName("毛泽东");
        t2.setName("江青");
        t1.start();
        t2.start();
    }
}

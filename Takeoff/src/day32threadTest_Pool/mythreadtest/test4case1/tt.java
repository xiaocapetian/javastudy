package day32threadTest_Pool.mythreadtest.test4case1;

public class tt {
    public static void main(String[] args) {
        Runtt4 runtt4 = new Runtt4();
        Thread t1 = new Thread(runtt4);
        Thread t2 = new Thread(runtt4);
        Thread t3 = new Thread(runtt4);
        Thread t4 = new Thread(runtt4);
        Thread t5 = new Thread(runtt4);
        t1.setName("毛泽东");
        t2.setName("毛远新");
        t3.setName("蒯大富");
        t4.setName("刘少奇");
        t5.setName("赫鲁晓夫");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}

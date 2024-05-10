package day31thread.a09threadsafe1;

public class tt9 {
    public static void main(String[] args) {
        runtt9 run = new runtt9();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        t1.setName("毛泽东");
        t2.setName("刘少奇");
        t3.setName("康生");
        t1.start();
        t2.start();
        t3.start();
    }
}

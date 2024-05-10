package day31thread.a02threadcase2;

public class ss2 {
    public static void main(String[] args) {
        //构造一个 thread,传进去一个实现Runnable接口的实现类
        runss2 run = new runss2();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

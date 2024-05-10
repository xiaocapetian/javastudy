package day31thread.a01threadcase1;

public class ss1 {
    /*(一共三个启动方式)
     * 多线程的第一种启动方式：
     *   1. 自己定义一个类继承Thread
     *   2. 重写run方法
     *   3. 创建子类的对象，并启动线程
     * */
    public static void main(String[] args) {
        //创建thread的子类对象，thread来start就可以了
        ss1Thread t1 = new ss1Thread();
        ss1Thread t2 = new ss1Thread();
        t1.setName("线程1");
        t1.start();
        t2.start();
    }



}

package day31thread.a13waitandnotify;

public class Desktt {

    /*
     * 作用：控制生产者和消费者的执行
     *
     * */
    public static int foodFlag = 0;//0 没有面条,1 有面条
    public static int count = 10;//还能再吃10碗面条
    public static Object lock = new Object();

}

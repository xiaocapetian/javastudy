package day32threadTest_Pool.mythreadtest.test2;

public class tt2 {
    public static void main(String[] args) {
             /*
            有100份礼品,两人同时发送，当剩下的礼品小于10份的时候则不再送出，
            利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来.
        */
        runtt r = new runtt();//只要一个runnable的实现类就行!
        Thread t1 = new Thread(r,"林");
        Thread t2 = new Thread(r,"猫");

        t1.start();
        t2.start();
    }
}

package day31thread.a01threadcase1;

public class ss1Thread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"qq");
        }

    }
}

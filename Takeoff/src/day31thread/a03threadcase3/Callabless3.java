package day31thread.a03threadcase3;

import java.util.concurrent.Callable;

public class Callabless3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum+=i;
            //sum = sum+i;
        }
        return sum;
    }
}

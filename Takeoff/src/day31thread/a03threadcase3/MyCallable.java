package day31thread.a03threadcase3;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
//Callable是有泛型的，这个泛型是结果的类型
    @Override
    public Integer call() throws Exception {
        //求1~100之间的和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
        }
        return sum;
    }
}

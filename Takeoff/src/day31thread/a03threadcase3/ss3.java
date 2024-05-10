package day31thread.a03threadcase3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ss3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callabless3 calls = new Callabless3();
        FutureTask<Integer> ft = new FutureTask<>(calls);
//构造一个 thread,传进去一个FutureTask<T>(CC)   C是Callable<T>接口的实现类
        //管理多线程运行的结果   ↑↑         表示多线程执行的任务  ↑↑
        Thread t1 = new Thread(ft);     //总结法二和法三, new Thread()可以传进去一个 FutureTask<T>或者一个自写的Runnable接口的实现类
                                            //FutureTask<T>是内部写好的Runnable接口的实现类 ↑↑
        t1.start();
        Integer result = ft.get();
        System.out.println(result);


    }
}

package day32threadTest_Pool.mythreadtest.test5;

import java.util.ArrayList;
import java.util.Collections;

public class Threadtt5 extends Thread{
    static public int count = 0;
    static {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,10,5,20,50,100,200,500,800,2,80,300,700);
    }//这个不知道怎么调用


    @Override
    public void run() {


    }
}

package leetcode1000;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class l1226 {
    class DiningPhilosophers {
        //1个Fork视为1个ReentrantLock，5个叉子即5个ReentrantLock，将其都放入数组中
        private final ReentrantLock[] lockList = {
                new ReentrantLock(),
                new ReentrantLock(),
                new ReentrantLock(),
                new ReentrantLock(),
                new ReentrantLock()};

        //限制 最多只有4个哲学家去持有叉子
        private Semaphore eatLimit = new Semaphore(4);

        public DiningPhilosophers() {

        }

/*        作者： ̶.̶G̶F̶u̶＇̶ 、̶ ̶|
        链接：https://leetcode.cn/problems/the-dining-philosophers/solutions/36049/1ge-semaphore-1ge-reentrantlockshu-zu-by-gfu/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/


        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher, //哲学家的编号
                               Runnable pickLeftFork,  //pickLeftFork 和 pickRightFork 表示拿起左边或右边的叉子。
                               Runnable pickRightFork,
                               Runnable eat,//eat 表示吃面。
                               Runnable putLeftFork,//putLeftFork 和 putRightFork 表示放下左边或右边的叉子。
                               Runnable putRightFork) throws InterruptedException {

            int leftFork = (philosopher + 1) % 5;    //左边的叉子 的编号
            int rightFork = philosopher;    //右边的叉子 的编号

            eatLimit.acquire();    //限制的人数 -1

            lockList[leftFork].lock();    //拿起左边的叉子
            lockList[rightFork].lock();    //拿起右边的叉子

            pickLeftFork.run();    //拿起左边的叉子 的具体执行
            pickRightFork.run();    //拿起右边的叉子 的具体执行

            eat.run();    //吃意大利面 的具体执行

            putLeftFork.run();    //放下左边的叉子 的具体执行
            putRightFork.run();    //放下右边的叉子 的具体执行

            lockList[leftFork].unlock();    //放下左边的叉子
            lockList[rightFork].unlock();    //放下右边的叉子

            eatLimit.release();//限制的人数 +1

        }
    }
}

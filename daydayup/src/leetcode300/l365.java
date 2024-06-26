package leetcode300;

import java.util.*;

public class l365 {
    //8种状态,
    //1.装满a
    //2.装满b
    //3.清空a
    //4.清空b
    //5.a->b a空
    //6.a->b b满
    //7.b->a b空
    //8.b->a a满
    /**
     *
     * @param x
     * @param y
     * @param target
     * @return
     */
    public boolean canMeasureWater(int x, int y, int target) {

        // 特判
        if (target == 0) {
            return true;
        }
        if (x + y < target) {
            return false;
        }
        State initState = new State(0, 0);

        // 广度优先遍历使用队列
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        queue.offer(initState);
        visited.add(initState);

        while (!queue.isEmpty()) {
            State head = queue.poll();

            int curX = head.getX();
            int curY = head.getY();

            // curX + curY == target1 比较容易忽略
            if (curX == target || curY == target || curX + curY == target) {
                return true;
            }

            // 从当前状态获得所有可能的下一步的状态
            List<State> nextStates = getNextStates(curX, curY, x, y);

            // 打开以便于观察，调试代码
            // System.out.println(head + " => " + nextStates);

            for (State nextState : nextStates) {
                if (!visited.contains(nextState)) {//如果这个状态曾经来到过
                    queue.offer(nextState);
                    // 添加到队列以后，必须马上设置为已经访问，否则会出现死循环
                    visited.add(nextState);
                }
            }
        }
        return false;
    }

//        作者：liweiwei1419
//        链接：https://leetcode.cn/problems/water-and-jug-problem/solutions/161837/tu-de-yan-du-you-xian-bian-li-by-liweiwei1419/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        private List<State> getNextStates(int curX, int curY, int Xmax, int Ymax) {
            // 最多 8 个对象，防止List<>动态数组扩容，不过 Java 默认的初始化容量肯定大于 8 个
            List<State> nextStates = new ArrayList<>(8);

            // 按理说应该先判断状态是否存在，再生成「状态」对象，这里为了阅读方便，一次生成 8 个对象

            // 以下两个状态，对应操作 1
            // 外部加水，使得 A 满
            State nextState1 = new State(Xmax, curY);
            // 外部加水，使得 B 满
            State nextState2 = new State(curX, Ymax);

            // 以下两个状态，对应操作 2
            // 把 A 清空
            State nextState3 = new State(0, curY);
            // 把 B 清空
            State nextState4 = new State(curX, 0);

            // 以下四个状态，对应操作 3
            // 从 A 到 B，使得 B 满，A 还有剩
            State nextState5 = new State(curX - (Ymax - curY), Ymax);
            // 从 A 到 B，此时 A 的水太少，A 倒尽，B 没有满
            State nextState6 = new State(0, curX + curY);

            // 从 B 到 A，使得 A 满，B 还有剩余
            State nextState7 = new State(Xmax, curY - (Xmax - curX));
            // 从 B 到 A，此时 B 的水太少，B 倒尽，A 没有满
            State nextState8 = new State(curX + curY, 0);

            // 没有满的时候，才需要加水
            if (curX < Xmax) {
                nextStates.add(nextState1);
            }
            if (curY < Ymax) {
                nextStates.add(nextState2);
            }

            // 有水的时候，才需要倒掉
            if (curX > 0) {
                nextStates.add(nextState3);
            }
            if (curY > 0) {
                nextStates.add(nextState4);
            }

            // 有剩余才倒
            if (curX - (Ymax - curY) > 0) {
                nextStates.add(nextState5);
            }
            if (curY - (Xmax - curX) > 0) {
                nextStates.add(nextState7);
            }

            // 倒过去倒不满才倒
            if (curX + curY < Ymax) {
                nextStates.add(nextState6);
            }
            if (curX + curY < Xmax) {
                nextStates.add(nextState8);
            }
            return nextStates;
        }

        private class State {
            private int x;
            private int y;

            public State(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }

            @Override
            public String toString() {
                return "State{" +
                        "x=" + x +
                        ", y=" + y +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                State state = (State) o;
                return x == state.x &&
                        y == state.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

    public static void main(String[] args) {
        //Solution solution = new Solution();
        l365 solution = new l365();
        int x = 3;
        int y = 5;
        int z = 4;

//        int x = 2;
//        int y = 6;
//        int z = 5;

//        int x = 1;
//        int y = 2;
//        int z = 3;
        boolean res = solution.canMeasureWater(x, y, z);
        System.out.println(res);
    }


//        作者：liweiwei1419
//        链接：https://leetcode.cn/problems/water-and-jug-problem/solutions/161837/tu-de-yan-du-you-xian-bian-li-by-liweiwei1419/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}

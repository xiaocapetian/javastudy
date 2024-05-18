package leetcode300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 荣耀笔试有一题我用到了类似的思路,所以现在把这题自己写一遍
 * 可以的,我做出来啦
 */
public class l365v1 {
    public static void main(String[] args) {
        l365v1 s = new l365v1();
        s.canMeasureWater(1,2,3);
    }
    int X;
    int Y;
    int Target;
    //如果想这样子就得重写 hashCode 和 equals 方法,才能在x和y相同时被视为一个key
    //HashSet<WaterState> hasvisited = new HashSet<>();
    boolean[][] hasvisited;
    public boolean canMeasureWater(int x, int y, int target) {
        X = x;
        Y = y;
        hasvisited = new boolean[x+1][y+1];
        Target = target;
        WaterState init = new WaterState(0,0);
        //hasvisited[0][0] = true;
        return find(init);
    }
    public boolean find(WaterState nowWaterState){
        hasvisited[nowWaterState.x][nowWaterState.y]=true;
        if(nowWaterState.x==Target||nowWaterState.y==Target||nowWaterState.x+nowWaterState.y==Target){
            return true;
        }
        List<WaterState> nextState = getNextState(nowWaterState);
        //boolean res ;
        for (WaterState waterState : nextState) {
            boolean res1 = find(waterState);
            if(res1){
                return true;
            }
        }
        return false;
    }
    public List<WaterState> getNextState(WaterState nowWaterState){
        //1.装满a
        //2.装满b
        //3.清空a
        //4.清空b
        //5.a->b a空
        //6.a->b b满
        //7.b->a b空
        //8.b->a a满
        List<WaterState> nextState = new ArrayList<>();
        int x = nowWaterState.x;
        int y = nowWaterState.y;

        //1.装满a
        //2.装满b
        if(!hasvisited[X][y]){
            nextState.add(new WaterState(X,y));
        }
        if(!hasvisited[x][Y]){
            nextState.add(new WaterState(x,Y));
        }
        //3.清空a
        //4.清空b
        if(!hasvisited[0][y]){
            nextState.add(new WaterState(0,y));
        }
        if(!hasvisited[x][0]){
            nextState.add(new WaterState(x,0));
        }
        //5.a->b a空
        if(x+y<=Y&&!hasvisited[0][y+x]){
            nextState.add(new WaterState(0,y+x));
        }
        //7.b->a b空
        if(x+y<=X&&!hasvisited[y+x][0]){
            nextState.add(new WaterState(y+x,0));
        }

        //6.a->b b满
        if(x+y>Y&&!hasvisited[x-(Y-y)][Y]){
            nextState.add(new WaterState(x-(Y-y),Y));
        }
        //8.b->a a满
        if(x+y>X&&!hasvisited[X][y - (X-x)]){
            nextState.add(new WaterState(X,y - (X-x)));
        }
        return nextState;
    }
    class WaterState{
        int x;
        int y;

        public WaterState() {
        }

        public WaterState(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * 获取
         * @return x
         */
        public int getX() {
            return x;
        }

        /**
         * 设置
         * @param x
         */
        public void setX(int x) {
            this.x = x;
        }

        /**
         * 获取
         * @return y
         */
        public int getY() {
            return y;
        }

        /**
         * 设置
         * @param y
         */
        public void setY(int y) {
            this.y = y;
        }

        public String toString() {
            return "WaterState{x = " + x + ", y = " + y + "}";
        }
    }
}

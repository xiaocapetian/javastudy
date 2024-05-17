package chongle.rongyao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//9 200 10
public class tt2 {
    static int D;
    static int T;
    static boolean jixu = true;
    static List<String> jieguo = new ArrayList<>();
    //static int length;//走过了路程
    //static int time;//过去了时间
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int M = in.nextInt();//初始魔法值
            D = in.nextInt();//距离安全地带距离
            T = in.nextInt();//距离火山爆发时间
            //System.out.println(M+","+D+","+T+",");
            //要在T内逃D米,如果能逃输出最短时间,如果不能逃输出最远距离
            //选择1 d+17 m+0
            //选择2 d+0 m+10
            //选择3 d+60 m-10
            State state = new State(0,M,0);
            find(state);
            String resno="";
            String resyes="";
            boolean can = false;
            int nonummax = 0;
            int yestimemin = Integer.MAX_VALUE;
            for (String s : jieguo) {
                String[] sarr = s.split(" ");
                if(sarr[0].equals("NO")){
                    if(nonummax <Integer.parseInt(sarr[1])){
                        resno = s;
                        nonummax = Integer.parseInt(sarr[1]);
                    }
                }else {
                    can = true;
                    if(yestimemin >Integer.parseInt(sarr[1])){
                        resyes = s;
                        yestimemin = Integer.parseInt(sarr[1]);
                    }
                }
            }
            System.out.println(jieguo);
            if(can){System.out.println(resyes);}
            else {
                System.out.println(resno);
            }

        }
    }

    private static void find(State state) {
        if(state.d>=D){
            //jixu = false;
            //System.out.println("YES "+state.time);
            String res = "YES "+state.time;
            jieguo.add(res);
            return ;
        }
        else if(state.time>=T){
            //jixu = false;
            //System.out.println("NO "+state.d);
            String res ="NO "+state.d;
            jieguo.add(res);
            return ;
        }

        List<State> maybenext = findnext(state);
        //while ()
        for (State nextstate : maybenext) {
            find(nextstate);
        }
        //return res;
    }

    static List<State> findnext(State nowstate){
        //System.out.println("now time="+nowstate.time+"m="+nowstate.m+", d="+nowstate.d);
        int time = nowstate.time;
        int m = nowstate.m;
        int d = nowstate.d;
        List<State> nextstate = new ArrayList<>();
        //若m>10
        if(m>10){
            State state = new State(d+60,m-10,time+1);
            nextstate.add(state);
            //若不>10
        }else {
            State state1 = new State(d+17,m,time+1);
            nextstate.add(state1);
            if(time<T-1){
                State state2 = new State(d,m+4,time+1);
                nextstate.add(state2);}


        }
        return nextstate;
    }
    static class State{
        int time;
        int d;
        int m;
        //List<State> nextstate;
        State(int d,int m,int t){
            this.d = d;
            this.m = m;
            this.time = t;
            //nextstate = new ArrayList<>();
        }

    }
}
/*输入样例
  9 100 3
 */
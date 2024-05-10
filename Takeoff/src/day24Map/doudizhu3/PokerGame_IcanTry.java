package day24Map.doudizhu3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame_IcanTry {
    static ArrayList<String> list = new ArrayList<>();
    //牌的价值
    static HashMap<String,Integer> hm = new HashMap<>();
    static {
        //准备牌
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (int i = 0; i < number.length; i++) {
            for (int i1 = 0; i1 < color.length; i1++) {

                list.add(color[i1]+number[i]);
            }
        }
        list.add("小猫");
        list.add("大猫");

        //System.out.println(paihe);
        //指定牌的价值
        //牌上的数字到Map集合中判断是否存在
        //存在，获取价值
        //不存在，本身的数字就是价值
        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("小猫", 16);
        hm.put("大猫", 17);
    }
    public PokerGame_IcanTry() {
        //洗牌
        Collections.shuffle(list);
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(i<=2){
                lord.add(list.get(i));
            }else {
                if(i%3==0)player1.add(list.get(i));
                else if(i%3==1)player2.add(list.get(i));
                else player3.add(list.get(i));
            }
        }
        order(player1);
        order(player2);
        order(player3);
        order(lord);
        lookPoker("地主牌",lord);
        lookPoker("毛泽东",player1);
        lookPoker("江青",player2);
        lookPoker("林彪",player3);

    }
    public void lookPoker(String name, ArrayList<String> list){

        System.out.println(name + " : " +list);
    }
    public void order(ArrayList<String> list){
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(getValue(o1)!=getValue(o2))return getValue(o1)-getValue(o2);
                //else {return o1.charAt(1)-o2.charAt(1);}
                else {return o1.compareTo(o2);}//也可以这样写！
            }
        });

    }
    public int getValue(String s){
        if(s.charAt(0) != '小' && s.charAt(0) != '大'){s = s.substring(1);}
        //如果表中有，从表中获取
        if(hm.containsKey(s))return hm.get(s);
        //表中没有，类型转换
        else return Integer.parseInt(s);
    }


}

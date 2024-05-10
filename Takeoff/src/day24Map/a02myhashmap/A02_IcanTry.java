package day24Map.a02myhashmap;

import java.util.*;

public class A02_IcanTry {
    public static void main(String[] args) {
        /*
            某个班级80名学生，现在需要组成秋游活动，
            班长提供了四个景点依次是（A、B、C、D）,
            每个学生只能选择一个景点，请统计出最终哪个景点想去的人数最多。
        */
        //1.需要先让同学们投票
        //定义一个数组，存储4个景点
        String[] arr = {"A","B","C","D"};
        //利用随机数模拟80个同学的投票，并把投票的结果存储起来
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(arr.length);
            list.add(arr[index]);
        }
        HashMap<String,Integer> hm = new HashMap<>();
        for (String name : list){
            if(!hm.containsKey(name)){
                hm.put(name,1);
            }else {
                int count = hm.get(name);
                count++;
                hm.put(name,count);
            }
        }

        System.out.println(hm);
        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        for (Map.Entry<String, Integer> entry:entries){
            int count = entry.getValue();
        }
    }
}

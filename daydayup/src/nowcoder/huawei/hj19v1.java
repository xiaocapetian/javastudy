package nowcoder.huawei;

import java.util.*;
/**
 * 题解
 * 重难点1,同时维护一个map一个记录顺序的list[queue没用好]
 * 重难点2,String[] split = quanpath.split("\\\\");//[难点] \\在java表示与1个\ ,
 * 重难点3 巧妙改进queue
 */
public class hj19v1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        HashMap<String,Integer> hashMap = new HashMap<>();
        //Queue<String> queue =new LinkedList<>();
        List<String> list =new ArrayList<>();
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String quanpath = s.split(" ")[0];
            String[] split = quanpath.split("\\\\");//[难点] \\在java表示与1个\ ,
            String path = split[split.length-1];
            if(path.length()>16){path = path.substring(path.length()-16);}
            String hang = s.split(" ")[1];
            String key = path+" "+hang;
/*            if(queue.size()==8&&!hashMap.containsKey(key)){
                String poll = queue.poll();
                hashMap.remove(poll);                       //即使是重的也别从map里移除
                queue.add(key);
                hashMap.put(key,1);
            }else if(queue.size()==8&&hashMap.containsKey(key)){
                hashMap.put(key,hashMap.getOrDefault(key,0)+1);
            }else if(queue.size()<8&&!hashMap.containsKey(key)){
                hashMap.put(key,hashMap.getOrDefault(key,0)+1);
                queue.add(key);
            }
            else if(queue.size()<8&&hashMap.containsKey(key)){
                hashMap.put(key,hashMap.getOrDefault(key,0)+1);
            }*/
            if(!hashMap.containsKey(key)){
                list.add(key);
                hashMap.put(key,1);
            }else {
                hashMap.put(key,hashMap.get(key)+1);
            }
        }
        if(list.size()<=8){
            for (String s : list) {
                System.out.println(s+" "+hashMap.get(s));
            }
        }else {
            for (int i = list.size()-8; i < list.size(); i++) {
                System.out.println(list.get(i)+" "+hashMap.get(list.get(i)));
            }
        }
//        while (!queue.isEmpty()){
//            String poll = queue.poll();
//            System.out.println(poll+" "+hashMap.get(poll));
//        }
    }
}

package nowcoder.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hj88 {
    static Map<String,Integer> map;
    public static void main(String[] args) {
        map = new HashMap<String,Integer>(){{
            put("3",3);
            put("4",4);
            put("5",5);
            put("6",6);
            put("7",7);
            put("8",8);
            put("9",9);
            put("10",10);
            put("J",11);
            put("Q",12);
            put("K",13);
            put("A",14);
            put("2",15);
            put("joker",16);
            put("JOKER",17);
        }};
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String s1 = s.split("-")[0];
            String s2 = s.split("-")[1];

            System.out.println(compare(s1,s2));

        }
    }
    public static String compare(String s1, String s2){
        String[] s1arr = s1.split(" ");
        String[] s2arr = s2.split(" ");
        if(s1.equals("joker JOKER")||s2.equals("joker JOKER")){
            return "joker JOKER";
        }
        if(s1arr.length==4&&s2arr.length==4){
            if(map.get(s1arr[0])>=map.get(s1arr[0])){return s1;}
            else {return s2;}
        }else if(s1arr.length==4){
            return s1;
        }else if(s2arr.length==4){
            return s2;
        }
        if(s1arr.length!=s2arr.length){
            return "ERROR";
        }else {
            if(map.get(s1arr[0])>=map.get(s2arr[0])){return s1;}//[]复制的时候一定要看清楚啊!!!!
            else {return s2;}
        }

    }
}

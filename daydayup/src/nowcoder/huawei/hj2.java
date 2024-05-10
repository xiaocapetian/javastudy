package nowcoder.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 这题总结出什么来?其实可以拿数组存是吧
 * Character.toUpperCase()大写小写转换
 */
public class hj2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String target = in.nextLine();
            char tar = target.charAt(0);
            HashMap<Character,Integer> hash = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char cup = Character.toUpperCase(s.charAt(i));
                hash.put(cup,hash.getOrDefault(cup,0)+1);
            }
            char tarup = Character.toUpperCase(tar);
            /*如果这地方是null,其实是要输出0的!数组就不用这个问题*/
            if(hash.get(tarup)==null){System.out.println(0);}
            else {System.out.println(hash.get(tarup));}

        }
    }
}

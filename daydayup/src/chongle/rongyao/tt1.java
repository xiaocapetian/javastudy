package chongle.rongyao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class tt1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            int[] num = new int[s1.length];
            num[0] = Integer.parseInt(s1[0].substring(1));
            num[num.length-1] = Integer.parseInt(s1[num.length-1].substring(0,1));
            for (int i = 1;i<num.length-1;i++){
                num[i] = Integer.parseInt(s1[i]);
            }
            Map<Integer,Integer> map =new HashMap<>();
            for (int i = 0; i < num.length; i++) {
                map.put(num[i],map.getOrDefault(num[i],0)+1 );
            }
            int res=0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                if(integerIntegerEntry.getValue()>1){
                    res+=integerIntegerEntry.getKey();
                }
            }
            System.out.println(res);
            //System.out.println(Arrays.toString(s1));
            //System.out.println(Arrays.toString(num));
        }
    }
}
/*输入样例
 [1 1 2 3]
 */

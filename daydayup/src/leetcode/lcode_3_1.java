package leetcode;
//用的哈希表，986 / 987 个通过的测试用例，但是最后一个超出时间限制了
//
import java.util.HashMap;
import java.util.Map;

public class lcode_3_1 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0 ;
        Map<Integer,Character> hashtable = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if(!hashtable.containsValue(s.charAt(i))){
                hashtable.put(i,s.charAt(i));
                max = Math.max(max, hashtable.size());
                System.out.println('a');
                System.out.println(hashtable);
            }else{
                int last = 0;
                for(Map.Entry<Integer,Character> entry:hashtable.entrySet()){
                    if(entry.getValue().equals(s.charAt(i))){
                        last = entry.getKey();
                    }
                }
                for (int i1 = 0; i1 < last+1; i1++) {
                    hashtable.remove(i1);
                }
                hashtable.put(i,s.charAt(i));
            }
        }
        return max;
    }

}


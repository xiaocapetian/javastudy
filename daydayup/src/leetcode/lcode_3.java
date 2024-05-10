package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lcode_3 {
    //感觉v2简单多了啊
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        //两个指针遍历
        //一旦右指针走到重复的位置了，就要更新左指针位置，怎么确定更新到哪呢？
        //左指针要走到上一个重复点位置处
        int left = -1 ,res = 0;
        Map<Character,Integer> hash = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {


            if(hash.containsKey(s.charAt(right))){//
                System.out.println("right的点和hash里重复,left要动了,left="+left+",hash.get(s.charAt(right))="+hash.get(s.charAt(right)));
                left = Math.max(left,hash.get(s.charAt(right)));//left取的是遇到重复的时，覆盖之前重复点的位置
                //left = hash.get(s.charAt(right));//不能这么写,为什么?下面详细说👇

            }
            System.out.println("right= "+ right +" left="+left);
            hash.put(s.charAt(right),right);//存的是这个点,和

            //max有变化就更新
            res = Math.max(res,right-left);
            System.out.println("res="+res);
            System.out.println(hash);
        }

        return res;
    }
/*    作者：powcai
    链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/3982/hua-dong-chuang-kou-by-powcai/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
/*right= 0 left=-1
res=1
{a=0}
right= 1 left=-1
res=2
{a=0, b=1}
right的点和hash里重复,left要动了,left=-1,hash.get(s.charAt(right))=1
right= 2 left=1
res=2
{a=0, b=2}
right的点和hash里重复,left要动了,left=1,hash.get(s.charAt(right))=0
right= 3 left=1
res=2
{a=3, b=2}
* */
// ===================================
/*right= 0 left=-1
res=1
{a=0}
right= 1 left=-1
res=2
{a=0, b=1}
right的点和hash里重复,left要动了,left=-1,hash.get(s.charAt(right))=1
right= 2 left=1
res=2
{a=0, b=2}
right的点和hash里重复,left要动了,left=1,hash.get(s.charAt(right))=0   👈 [你看看这里,错了吧]
right= 3 left=0
res=3
{a=3, b=2}
* */
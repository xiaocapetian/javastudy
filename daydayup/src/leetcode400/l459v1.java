package leetcode400;

import java.util.Arrays;

public class l459v1 {
    //kmp算法
    public boolean repeatedSubstringPattern(String s) {
        //想通一点,最长相等前后缀排除的那部分就是子串
        /*
 ababab
   ababab
        * */
        int[] next = new int[s.length()];
        getNextArr(next,s);
        //原字符串长度-最长相等前后缀的长度(那么这个最长相等前后缀是什么?
        // 别忘了next前缀表中的数字 就是最长相等前后缀)
        System.out.println(Arrays.toString(next));
        return  next[next.length - 1]>0&&s.length() % (s.length() - next[next.length - 1]) == 0;
    }
    public void getNextArr(int[] next,String s){
        int j = 0;
        next[0] = 0;
        // 构造 next 数组过程，j从0开始(空格)，
        for(int i = 1;i<s.length();i++){
            // 匹配不成功，j回到前一位置 next 数组所对应的值
            while (j>0&&s.charAt(i)!=s.charAt(j)){
                j = next[j-1];
            }
            // 匹配成功，j往后移
            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
            // 更新 next 数组的值
            next[i] = j;
        }
    }
}

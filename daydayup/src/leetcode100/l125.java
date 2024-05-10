package leetcode100;

import java.util.Arrays;

public class l125 {
    public boolean isPalindrome2(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            //所有非字母数字字符就跳过
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }

            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/valid-palindrome/solutions/292148/yan-zheng-hui-wen-chuan-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        //List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                //char c = (char) (s.charAt(i)-'A'+'a');
                sb.append((char) (s.charAt(i)-'A'+'a'));/*这里一定要强转(char)之后才能放进去,否则放进去的是两个数字!!*/
            }else if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                sb.append(s.charAt(i));
            }
        }
        char[] sarr = sb.toString().toCharArray();
        System.out.println(Arrays.toString(sarr));
        int left=0;
        int right = sarr.length-1;
        while (right>left){
            if(sarr[left]!=sarr[right])return false;
            left++;
            right--;
        }
        return true;
    }
}

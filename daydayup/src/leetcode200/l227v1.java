package leetcode200;

import java.util.ArrayDeque;
import java.util.Deque;

public class l227v1 {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        char preSign = '+';//第一个上一个符号是+
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            //Character.isDigit(char ch) 判断ch是否是一个数字字符
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';//如果是数字字符,继续改造这个数字
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                //如果是符号了,
                //看存的"上一个符号"是什么  👈 [只有看到符号,才对上一个符号做运算]
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);//加号减号直接存正数负数
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);//存下上一个符号
                num = 0;//归0
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/basic-calculator-ii/solutions/648647/ji-ben-ji-suan-qi-ii-by-leetcode-solutio-cm28/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

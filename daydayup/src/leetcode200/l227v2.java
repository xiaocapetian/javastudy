package leetcode200;

import java.util.*;

/**
 * 大佬做的全能
 * 使用两个栈 nums 和 ops：
 * nums ： 存放所有的数字
 * ops ：存放所有的数字以外的操作
 * //令人震惊的发现啊,以后不用Stack<Character>了,仅仅是把Stack换成deque,马上速度提升很大!!!而且双端队列还比stack功能更多,有什么理由不用呢?
 */
public class l227v2 {
    public static void main(String[] args) {
        l227v2 s = new l227v2();
        s.calculate("3+2*2");
    }
    // 使用 map 维护一个运算符优先级
    // 这里的优先级划分按照「数学」进行划分即可
    Map<Character,Integer> map = new HashMap<>(){{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
        put('%', 2);
        put('^', 3);
    }};
    public int calculate(String s) {
// 将所有的空格去掉
        s = s.replaceAll(" ", "");
        char[] carr = s.toCharArray();
        int n = s.length();
        // 存放所有的数字
        Stack<Integer> numsStack = new Stack<>();
        // 为了防止第一个数为负数，先往 nums 加个 0
        numsStack.add(0);
// 存放所有「非数字以外」的操作
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < carr.length; i++) {
            char c = carr[i];
            if(c=='('){
                ops.add(c);
            }else if(c==')'){
                while (!ops.isEmpty()){
                    if(ops.peek()!='('){
                        calc(numsStack,ops);
                    }else {
                        ops.pop();//把'('弹出来
                        break;
                    }
                }
            }
            else {
                //如果是数字
                if(Character.isDigit(c)){
                    int u=0;
                    int j = i;
                    while (j<carr.length&&Character.isDigit(carr[j])){
                        u = u*10+(carr[j]-'0');
                        j++;
                    }
                    numsStack.add(u);
                    i = j-1;
                }else {
                    //如果是运算符
                    //为防止 () 内出现的首个字符为运算符，将所有的空格去掉，并将 (- 替换为 (0-，(+ 替换为 (0+
                    // （当然也可以不进行这样的预处理，将这个处理逻辑放到循环里去做）
                    if (i > 0 && (carr[i - 1] == '(' || carr[i - 1] == '+' || carr[i - 1] == '-')) {
                        numsStack.add(0);
                    }
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    // 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
                    while (!ops.isEmpty()&&ops.peek()!='('){
                        char peek = ops.peek();
                        //比较运算符优先级如果现在遍历到的这个符号(+)小于或者等于之前栈顶的符号(*),就可以计算
                        if(map.get(peek)>=map.get(c)){
                            calc(numsStack,ops);
                        }else {
                            //现在遍历到(*),之前遍历的是(+)  比如6+3*7 那我问你你能遍历到*的时候就把6和3加了吗?
                            break;
                        }
                    }
                    ops.add(c);

                }
            }
            System.out.println("ops"+ops);
            System.out.println(numsStack);
        }
        while (!ops.isEmpty()){
            calc(numsStack,ops);
        }
        return numsStack.pop();
    }

    private void calc(Stack<Integer> numsStack, Stack<Character> ops) {
        if(numsStack.size()<2){return;}
        int b = numsStack.pop();
        int a = numsStack.pop();
        int fuhao = ops.pop();
        int res = 0;
        if(fuhao=='+'){res = a+b;}
        if(fuhao=='-'){res = a-b;}
        if(fuhao=='*'){res = a*b;}
        if(fuhao=='/'){res = a/b;}
        if(fuhao=='^'){res = a^b;}
        if(fuhao=='%'){res = a%b;}
        numsStack.add(res);

    }

    public int calculate2(String s) {
// 将所有的空格去掉
        s = s.replaceAll(" ", "");
        char[] carr = s.toCharArray();
        int n = s.length();
        // 存放所有的数字
        Deque<Integer> numsStack = new LinkedList<>();
        // 为了防止第一个数为负数，先往 nums 加个 0
        numsStack.add(0);
// 存放所有「非数字以外」的操作
        Deque<Character> ops = new LinkedList<>();
        for (int i = 0; i < carr.length; i++) {
            char c = carr[i];
            if(c=='('){
                ops.add(c);
            }else if(c==')'){
                while (!ops.isEmpty()){
                    if(ops.peekLast()!='('){
                        calc2(numsStack,ops);
                    }else {
                        ops.pollLast();//把'('弹出来
                        break;
                    }
                }
            }
            else {
                //如果是数字
                if(Character.isDigit(c)){
                    int u=0;
                    int j = i;
                    while (j<carr.length&&Character.isDigit(carr[j])){
                        u = u*10+(carr[j]-'0');
                        j++;
                    }
                    numsStack.add(u);
                    i = j-1;
                }else {
                    //如果是运算符
                    //为防止 () 内出现的首个字符为运算符，将所有的空格去掉，并将 (- 替换为 (0-，(+ 替换为 (0+
                    // （当然也可以不进行这样的预处理，将这个处理逻辑放到循环里去做）
                    if (i > 0 && (carr[i - 1] == '(' || carr[i - 1] == '+' || carr[i - 1] == '-')) {
                        numsStack.add(0);
                    }
                    // 有一个新操作要入栈时，先把栈内可以算的都算了
                    // 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
                    while (!ops.isEmpty()&&ops.peekLast()!='('){
                        char peek = ops.peekLast();
                        //比较运算符优先级如果现在遍历到的这个符号(+)小于或者等于之前栈顶的符号(*),就可以计算
                        if(map.get(peek)>=map.get(c)){
                            calc2(numsStack,ops);
                        }else {
                            //现在遍历到(*),之前遍历的是(+)  比如6+3*7 那我问你你能遍历到*的时候就把6和3加了吗?
                            break;
                        }
                    }
                    ops.add(c);

                }
            }
            System.out.println("ops"+ops);
            System.out.println(numsStack);
        }
        while (!ops.isEmpty()){
            calc2(numsStack,ops);
        }
        return numsStack.pop();
    }
    private void calc2(Deque<Integer> numsStack, Deque<Character> ops) {
        if(numsStack.size()<2){return;}
        int b = numsStack.pollLast();
        int a = numsStack.pollLast();
        int fuhao = ops.pollLast();
        int res = 0;
        if(fuhao=='+'){res = a+b;}
        if(fuhao=='-'){res = a-b;}
        if(fuhao=='*'){res = a*b;}
        if(fuhao=='/'){res = a/b;}
        if(fuhao=='^'){res = a^b;}
        if(fuhao=='%'){res = a%b;}
        numsStack.add(res);

    }
}
//        作者：宫水三叶
//链接：https://leetcode.cn/problems/basic-calculator-ii/solutions/648832/shi-yong-shuang-zhan-jie-jue-jiu-ji-biao-c65k/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
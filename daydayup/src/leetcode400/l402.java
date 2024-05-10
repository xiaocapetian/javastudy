package leetcode400;


import java.util.LinkedList;

/**
 * 这道题要想到单调栈
 */
public class l402 {
    /**
     *
     * @param num 给你一个以字符串表示的非负整数 num 和一个整数 k ，
     * @param k 移除k个 移除这个数中的 k 位数字，使得剩下的数字最小。
     * @return 请你以字符串形式返回这个最小的数字。
     */
    public String removeKdigits(String num, int k) {
        //Stack<Integer> stack
        char[] numArr = num.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            //如果k还没用完，最后一位又比这一位大，就要替换
            //char c = numArr[i];
            while(!list.isEmpty()&&list.getLast()>numArr[i]&&k>0){
                k--;
                //list.removeLast();
                list.pollLast();//poll移除，如果list为空会返回null而不是抛异常
            }
            list.add(numArr[i]);
        }
        while (k!=0){//如果k没用完，就从后往前剔除
            list.removeLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        //没想到以下两种写法差距居然如此之大?!?
        boolean diyilun = true;
        while (!list.isEmpty()) {
            char digit = list.pollFirst();
            if (diyilun && digit == '0') {
                continue;
            }
            diyilun = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
        /*while (!list.isEmpty()&&list.getFirst()=='0'){*//*【易错]:这里存的是索引，那比较的也应该是索引*//*

            list.removeFirst();
        }
        if(list.isEmpty())return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();*/
    }

    /**
     *1426ms
     * 不存索引了，改存字符
     */
    public String removeKdigits2(String num, int k) {

        //Stack<Integer> stack
        char[] numArr = num.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            //如果k还没用完，最后一位又比这一位大，就要替换
            //char c = numArr[i];
            while(!list.isEmpty()&&list.getLast()>numArr[i]&&k>0){
                k--;
                //list.removeLast();
                list.pollLast();//poll移除，如果list为空会返回null而不是抛异常
            }
            list.add(numArr[i]);
        }
        while (k!=0){//如果k没用完，就从后往前剔除
            list.removeLast();
            k--;
        }


        //if(!list.isEmpty())System.out.println(list.getFirst());
        while (!list.isEmpty()&&list.getFirst()=='0'){/*【易错]:这里存的是索引，那比较的也应该是索引*/

            list.removeFirst();
        }
        if(list.isEmpty())return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    /**
     * 2193ms  思路和答案一样，但是太慢了
     */
    public String removeKdigits1(String num, int k) {

        //Stack<Integer> stack
        char[] numArr = num.toCharArray();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        for (int i = 1; i < num.length(); i++) {
            //如果k还没用完，最后一位又比这一位大，就要替换
            while(!list.isEmpty()&&numArr[list.getLast()]>numArr[i]&&k>0){
                k--;
                //list.removeLast();
                list.pollLast();//poll移除，如果list为空会返回null而不是抛异常
            }
            list.add(i);
        }
        while (k!=0){//如果k没用完，就从后往前剔除
            list.removeLast();
            k--;
        }


        //if(!list.isEmpty())System.out.println(list.getFirst());
        while (!list.isEmpty()&&numArr[list.getFirst()]=='0'){/*【易错]:这里存的是索引，那比较的也应该是索引*/

            list.removeFirst();
        }
        if(list.isEmpty())return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(numArr[list.get(i)]);
        }
        return sb.toString();
    }
}


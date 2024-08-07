package leetcode900;

import java.util.Stack;

public class l946 {
    /**
     * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
     * @param pushed pushed = [1,2,3,4,5],
     * @param popped popped = [4,5,3,2,1]
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushItem = 0;
        for(int i =0; i<popped.length;i++){

            //System.out.println(popped[i]+","+stack);
            //现在我看到了popped[i],意味着它被推出来了，那么之前的所有已经放进去了
            //有2种可能， 1. 现在stack口是它， 2.要推进去一批然后遇见他
            int pop = popped[i];
            if(!stack.isEmpty()&&stack.peek()==pop){
                //System.out.println("stack里有"+stack.peek());
                stack.pop();
            }else {

                while (pushItem<pushed.length&&pushed[pushItem]!=pop){
                    //System.out.println("找不到pop="+pop+"要推"+pushed[pushItem]);
                    stack.push(pushed[pushItem]);
                    pushItem++;
                }
                pushItem++;
                if(pushItem>pushed.length){return false;}
                /*[易错]为什么这最后还要++啊，如果是因为pushed[pushItem]==pop而退出，那说明新加的直接取出来，应该往后顺一位
                * 如果是因为pushItem=pushed.length退出的，这里又+1位那就正好大于了，也就是说如果是 = ，那是因为正常到最后一位，
                * 而如果是>,那才是有问题导致向后走完了
                * */
                //System.out.println("可以了");

            }

        }
        return true;
    }
}

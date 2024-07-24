package leetcode600;

public class l678 {
    /**
     * 应该是对的，但是超时了，做了回溯
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {

        //Stack<Character> stack = new Stack<>();
        int zuoNum = 0;
        return cha(zuoNum,0,s);

    }
    private boolean cha(int zuoNum,int item,String s){
        for (int i = item; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                zuoNum++;
            }else if (s.charAt(i)=='*'){
                //当成左括号
                boolean k1 = cha(zuoNum+1,item+1,s);
                //当成空气
                boolean k2 = cha(zuoNum,item+1,s);
                //当成右括号
                boolean k3=false;
                if(zuoNum>0){
                    k3 = cha(zuoNum-1,item+1,s);
                }

                return k1 || k2 || k3;
            } else {//s.charAt(i)==')'
                if(zuoNum<=0){
                    return false;
                }
                zuoNum--;
            }
        }
        return zuoNum==0;

    }
}

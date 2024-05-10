package leetcode300;

import java.util.Stack;

public class l394 {
    //看了眼答案自己写的，
    public String decodeString(String s) {

        char[] carr = s.toCharArray();
        Stack<String> stack = new Stack<>();
        //int numzuo = 0;

        for(int i = 0;i<s.length();){
            System.out.println(stack);
            if(carr[i]>='a'&&carr[i]<='z'){
                StringBuilder sb2=new StringBuilder();
                while (i<s.length()&&carr[i]>='a'&&carr[i]<='z'){
                    sb2.append(carr[i]);
                    i++;
                }
                stack.push(sb2.toString());
            }else if((carr[i]>='0'&&carr[i]<='9')){
                int num = 0;
                while (carr[i]>='0'&&carr[i]<='9'){
                    num = num*10+(carr[i]-'0');
                    i++;
                }
                stack.push(num+"");
            } else if (carr[i]=='['){
                stack.push(String.valueOf(carr[i]));
                i++;
            }else if (carr[i]==']'){
                StringBuilder sb2 = new StringBuilder();

                while (!stack.peek().equals("[")){
                    sb2.insert(0,stack.pop());
                }
                String str = sb2.toString();
                stack.pop();// "["

                int num = Integer.parseInt(stack.pop());//数字
                for(int j = 1;j<num;j++){
                    sb2.append(str);
                }
                stack.push(sb2.toString());
                i++;
            }

        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }

}

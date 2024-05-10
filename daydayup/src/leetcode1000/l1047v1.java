package leetcode1000;

public class l1047v1 {
    public String removeDuplicates(String s) {
        //不真正用栈,而是用栈的思想
        StringBuilder sb = new StringBuilder();
        int top = -1;//top就放sb的第一位
        for (int i = 0; i < s.length(); i++) {
            if(top>=0&&sb.charAt(top)==s.charAt(i)){
                sb.deleteCharAt(top);
                top--;
            }else {
                sb.append(s.charAt(i));
                top++;
            }
        }
        return sb.toString();
    }
}

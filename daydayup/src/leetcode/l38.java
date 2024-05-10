package leetcode;

public class l38 {
    //纯自己写的,自己写的还快一点
    public static void main(String[] args) {
        //System.out.println(countAndSay(3));
        System.out.println(l38_1.countAndSay(4));
    }
    public static String countAndSay(int n) {
        if(n == 1){return "1";}
        return read(countAndSay(n-1));
    }
    public static String read(String before){
        //获得的是上一个,返回的是下一个
        StringBuilder sb  = new StringBuilder();

        char first = before.charAt(0);
        int num = 0;

        for (int i = 0; i < before.length(); i++) {
            char ch = before.charAt(i);
            if(first==ch){num++;}
            else {
                sb.append(num).append(first);
                first = ch;
                num = 1;
            }
        }sb.append(num).append(first);//难点是这句话要加,以及加在哪

        /*
        int pos = 0;
        int start = 0;
        while (pos<before.length()){
            while (pos<before.length()&&before.charAt(start)==before.charAt(pos)){pos++;}
            sb.append(pos-start).append(before.charAt(start));
            start = pos;
        }*/


        return sb.toString();
    }
}


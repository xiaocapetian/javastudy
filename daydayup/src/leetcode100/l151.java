package leetcode100;

import java.util.ArrayList;
import java.util.List;
//给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
public class l151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {

        char[] charsrr = s.toCharArray();
        //String[] strarr = new String[];
        List<String> listarr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= charsrr.length; i++) {
            if (i == charsrr.length || charsrr[i] == ' ') {
                if (!sb.isEmpty()) {
                    listarr.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(charsrr[i]);
            }
        }
        //String[] strarr = s.split(" ");
        if (!sb.isEmpty()) {
            listarr.add(sb.toString());
            sb.delete(0, sb.length());
        }

        int left = 0;
        int right = listarr.size() - 1;//strarr.length-1;
        while (left < right) {
            String temp = listarr.get(left);//strarr[left];
            //strarr[left] = strarr[right];
            //strarr[right] = temp;
            listarr.set(left, listarr.get(right));
            listarr.set(right, temp);

            left++;
            right--;
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < listarr.size(); i++) {
            sb2.append(listarr.get(i));
            if (i < listarr.size() - 1) {
                sb2.append(" ");
            }
        }
        return sb2.toString();
    }
}

/*        for (int i = 0; i < strarr.length; i++) {
            sb2.append(strarr[i]);
            if(i<strarr.length-1){
                sb2.append(" ");
            }
        }
        return sb2.toString();*/
        //sj用法
/*        StringJoiner sj = new StringJoiner(" ");
        for (String str : strarr) {
            sj.add(str);
        }

        return sj.toString();*/

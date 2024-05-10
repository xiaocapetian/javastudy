package nowcoder.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hj42 {
    static Map<String,String> map = new HashMap<String,String>(){{
        put("0","");
        put("1","one");
        put("2","two");
        put("3","three");
        put("4","four");
        put("5","five");
        put("6","six");
        put("7","seven");
        put("8","eight");
        put("9","nine");
        put("10","ten");
        put("11","eleven");
        put("12","twelve");
        put("13","thirteen");
        put("14","fourteen");
        put("15","fifteen");
        put("16","sixteen");
        put("17","seventeen");
        put("18","eighteen");
        put("19","nineteen");
        //put("20","twenty");
    }};
    static Map<String,String> map2 = new HashMap<String,String>(){{
        put("2","twenty");
        put("3","thirty");
        put("4","forty");
        put("5","fifty");
        put("6","sixty");
        put("7","seventy");
        put("8","eighty");
        put("9","ninety");
    }};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            //long a = in.nextLong();
            String s = in.nextLine();
            if(s.length()%3==1){s="00"+s;}
            if(s.length()%3==2){s="0"+s;}
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i<s.length();i=i+3){
                int j = s.length()-1-i;
                String san = san(s.substring(i, i + 3));
                sb.append(san);
                if(j/3==3){
                    sb.append(" billion ");
                } else if(j/3==2){
                    sb.append(" million ");
                } else if(j/3==1){
                    sb.append(" thousand ");
                }else {

                }
            }
            System.out.println(sb);
        }
    }

    private static String san(String s) {
        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        if(s.charAt(0)=='0'){//[]别写s.charAt(0)==0啊
            if(s.charAt(1)=='0'&&s.charAt(2)=='0'){
                return sb.toString();
            }else {
                if(s.charAt(1)=='1'){
                    sb.append(map.get(s.substring(1,3)));

                }else if(s.charAt(1)=='0'){
                    sb.append(map.get(s.substring(2,3)));

                }else {
                    sb.append(map2.get(s.substring(1,2)));
                    if(s.charAt(2)=='0'){return sb.toString();}
                    sb.append(" ");
                    sb.append(map.get(s.substring(2,3)));
                }
                return sb.toString();
            }
        } else {
            sb.append(map.get(s.charAt(0)+"")).append(" hundred");
            if(s.charAt(1)=='0'&&s.charAt(2)=='0'){
                return sb.toString();
            }
            else {
                sb.append(" and ");
                if(s.charAt(1)=='1'){
                    sb.append(map.get(s.substring(1,3)));

                }else if(s.charAt(1)=='0'){
                    sb.append(map.get(s.substring(2,3)));

                }else {
                    sb.append(map2.get(s.substring(1,2)));
                    if(s.charAt(2)=='0'){return sb.toString();}
                    sb.append(" ");
                    sb.append(map.get(s.substring(2,3)));
                }
                return sb.toString();
            }
        }

    }
}

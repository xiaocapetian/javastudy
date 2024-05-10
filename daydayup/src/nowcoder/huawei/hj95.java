package nowcoder.huawei;

import java.util.HashMap;
import java.util.Scanner;

//还是答案nb,我这个太复杂了
public class hj95 {
    public static String[] ten = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    static HashMap<String,String> map = new HashMap<String,String>(){{
        put("1","壹");
        put("2","贰");
        put("3","叁");
        put("4","肆");
        put("5","伍");
        put("6","陆");
        put("7","柒");
        put("8","捌");
        put("9","玖");
        put("10","拾");
        put("0","");
    }};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case

            String qstr = in.nextLine();
            Double q = Double.parseDouble(qstr);
            if(qstr.split("//.")[1].equals("00")){
                System.out.println("人民币" + solveZheng(qstr.split("//.")[0]) + "元整");
            } else if(qstr.split("//.")[0].equals("0")){
                System.out.println("人民币" + solveXiao(qstr.split("//.")[1]));
            }else {
                System.out.println("人民币" + solveZheng(qstr.split("//.")[0]) + "元" + solveXiao(qstr.split("//.")[1]));
            }
            String yuan = qstr.split("//.")[0];
            //while (yuan.length()%4!=0)
            int gao = yuan.length()%4;
            String str = fourTo(yuan.substring(0,gao));
            for(int i = gao;i+4<yuan.length();i++){
                fourTo(yuan.substring(i,i+4));
            }
        }
    }

    /**
     * 人家写的还挺好的哈
     * @param s
     * @return
     */
    private static String solveXiao(String s) {
        StringBuilder sb = new StringBuilder();
        int jiao = Integer.parseInt(s.substring(0,1));
        int fen = Integer.parseInt(s.substring(1,2));
        if(jiao!=0){
            sb.append(ten[jiao]);
            sb.append("角");
        }
        if(fen!=0){
            sb.append(ten[fen]);
            sb.append("分");
        }
        return sb.toString();
    }

    private static String solveZheng(String s) {
        return "";
    }

    private static String fourTo(String s) {
        if(s.length()!=4){return shouTo(s);}
        return "";
    }

    private static String shouTo(String s) {
        //
        if(s.length()==1){
            return map.get(s.substring(0,1));
        }else if(s.length()==2){
            if(s.charAt(0) == '0'){return "零"+map.get(s.substring(1,2));}
            if(s.charAt(0) == '1'){return "拾"+map.get(s.substring(1,2));}
            else {
                return map.get(s.substring(0,1))+"拾"+map.get(s.substring(1,2));
            }
        }else {//if(s.length()==3)
            if(s.charAt(1)=='0'){
                //return map.get()
            }
            return map.get(s.substring(0,1))+"佰"+shouTo(s.substring(1,3));
        }
    }
}

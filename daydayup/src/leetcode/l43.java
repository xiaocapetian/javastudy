package leetcode;

public class l43 {//自己写的已经AC,但是很慢
    public static void main(String[] args) {
        System.out.println(multiply("120","160"));
    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){return "0";}
        //int p2 = num2.length()-1;
        //int result= 0;
        //String result = "";
        StringBuilder sbresult = new StringBuilder();
        for (int p2 = 0;p2<num2.length();p2++){
        //while (p2>=0){
            int add=0;
            StringBuilder sb = new StringBuilder();
            int p = num1.length()-1;
            while (p>=0||add!=0){
                int c1 = p>=0?(num1.charAt(p)-'0'):0;
                int res = (num2.charAt(p2)-'0')*c1+add;
                sb.append(res%10);
                add = res/10;
                p--;
            }
            //result= Integer.parseInt(addStrings(result*10+"",sb.reverse().toString()));
            //result*10会导致溢出
            sbresult = addStrings(sbresult.append("0").toString(),sb.reverse().toString());
        }
        return sbresult.toString();
    }
    public static StringBuilder addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int jinwei = 0;
        StringBuilder sb = new StringBuilder();
        //String result = "";
        int ress = 0;
        while (p1 >= 0 || p2 >= 0||jinwei!=0) {
            int a1 = p1 >= 0 ? num1.charAt(p1)-'0' : 0;
            int a2 = p2 >= 0 ? num2.charAt(p2)-'0' : 0;
            int res = a1+a2+jinwei;
//            jinwei = 0;
//            if(res>9){
//                jinwei = 1;
//            }//不要这么判断了,多麻烦啊
            jinwei = res/10;
            //result = Integer.toString(res%10) + result;//字符串拼接太慢,要用sb
            sb.append(res % 10);
            p1--;p2--;
        }
        return sb.reverse();//关键是知道有这个:字符串翻转sb.reverse()
    }
    //别人写的,和我写的差不多嘛
    public String addStrings2(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }


}

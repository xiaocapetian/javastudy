package leetcode;

public class l43_1 {//抄了热评的,根本不快
    public static void main(String[] args) {
        System.out.println(multiply("120","160"));
    }
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";
        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;//进位
            // temp用来保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();

            // 补 0,  num2是三位数时:num2的个位数,i=2,补0个0,num2的百位数,i=0,补2个0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';// num2 第i位数字
            
            //
            for (int j = num1.length()-1; j >=0||carry!=0; j--) {
                int n1 = j>=0?num1.charAt(j) - '0':0;
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }

            res = addStrings(temp.reverse().toString(), res);

        }
        return res;
    }
    public static String addStrings(String num1, String num2) {
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
            jinwei = 0;
            if(res>9){
                jinwei = 1;
            }
            //result = Integer.toString(res%10) + result;//字符串拼接太慢,要用sb
            sb.append(Integer.toString(res%10));
            p1--;p2--;
        }
        return sb.reverse().toString();//关键是知道有这个:字符串翻转sb.reverse()
    }
}

package leetcode400;

public class l415 {
    public static void main(String[] args) {

        System.out.println(addStrings("11","123"));
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

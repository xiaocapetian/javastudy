package leetcode;

public class l8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("   "));
    }
    public static int myAtoi(String s) {

        char[] sarr = s.toCharArray();
        if (s.equals("")){
            return 0;
        }
        int index = 0;
        int sign = 1;
        int sun = 0;
        while (index < s.length()&&sarr[index]==' '){
            index++;
        }

        if (index < s.length() && (sarr[index] == '+' || sarr[index] == '-')) {
            sign = sarr[index++] == '+' ? 1 : -1;
        }
        while (index < s.length() && sarr[index] >= '0' && sarr[index] <= '9'){
            int num = sarr[index] - '0';
            if(sun>(Integer.MAX_VALUE-num)/10){
               return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            sun =sun*10+num;
            index++;
        }
        return sign*sun;
    }
}

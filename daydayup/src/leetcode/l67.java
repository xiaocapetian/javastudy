package leetcode;

public class l67 {
    //自己写的一遍过
    public String addBinary(String a, String b) {

        if(a.length()<b.length()){
            return addBinary(b,a);
        }
        //现在肯定时a.len>=b.len
        int jinwei=0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (;i<b.length();i++){
            if((b.charAt(b.length()-1-i)-'0')+(a.charAt(a.length()-1-i)-'0')+jinwei==0){
                sb.insert(0,"0");
            }else if ((b.charAt(b.length()-1-i)-'0')+(a.charAt(a.length()-1-i)-'0')+jinwei==1){
                sb.insert(0,"1");
                jinwei=0;
            }else if ((b.charAt(b.length()-1-i)-'0')+(a.charAt(a.length()-1-i)-'0')+jinwei==2){
                sb.insert(0,"0");
                jinwei=1;
            }else {//  ==3
                sb.insert(0,"1");
                jinwei=1;
            }
        }
        for (;i<a.length();i++){
            if((a.charAt(a.length()-1-i)-'0')+jinwei==0){
                sb.insert(0,"0");
            }else if ((a.charAt(a.length()-1-i)-'0')+jinwei==1){
                sb.insert(0,"1");
                jinwei=0;
            }else if ((a.charAt(a.length()-1-i)-'0')+jinwei==2){
                sb.insert(0,"0");
                jinwei=1;
            }
        }
        if(jinwei==1){sb.insert(0,"1");}//[易错]这里别漏了
        return sb.toString();
    }


    //用java 自带的高精度运算
    public String addBinary2(String a, String b) {
        int a2 =Integer.parseInt(a, 2);//a2 其实是十进制数,按2进制的方式读取来的, a = 11 那a2 = 3
        return Integer.toBinaryString(
                a2 + Integer.parseInt(b, 2)
        );
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/add-binary/solutions/299667/er-jin-zhi-qiu-he-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //答案写的好像更容易一点啊
    public String addBinary3(String a, String b) {
        StringBuffer sb = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;//余数留下来
        }

        if (carry > 0) {
            sb.append('1');
        }
        sb.reverse();//利用号这个翻转reverse()

        return sb.toString();
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/add-binary/solutions/299667/er-jin-zhi-qiu-he-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

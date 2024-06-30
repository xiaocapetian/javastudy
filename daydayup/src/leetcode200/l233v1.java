package leetcode200;

/**
 * 看的是宫水三叶的解析,但是我自己写就那么复杂,又非常的慢
 */
public class l233v1 {
    /**
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        //n = abcde 假设 13245
        //当我要看有多少_ _ 1_ _时 1__ __ _1___ 01000-01999 1000个
        //如果前两位<ab ,肯定可以,符合  ab00个 00100-00199...12100-12199  1300个
        //如果前两位>ab ,肯定不可以
        //如果前两位=ab , 看第三位, c = 0肯定不可以
        //                      c>1可以  100 个  13100-13199
        //                      c=1   de个  13145的话 那就13100-13145个
        String nstr = n + "";
        int res = 0;
        for (int i = 0; i < nstr.length(); i++) {
            int ab = nstr.substring(0, i).isEmpty()?0:Integer.parseInt(nstr.substring(0,i));

            int c = nstr.charAt(i)-'0';
            String destr = nstr.substring(i+1);
            int de = destr.isEmpty()?0:Integer.parseInt(destr);

            //如果de是"" 空 de算成0,但是在算位数的时候要视为10^0,
            //如果de是0     de算成0,但是算位数时要视为10^1
            //如果de是00     de算成0,但是算位数时要视为10^2

            //res+= (int) Math.pow(10,(de+"").length());
            //res+= (int) (ab*Math.pow(10,getwei(de)));
            /*[易错] 你能像👆上面两种方式那样求de的位数吗?de如果是001怎么办?明明是3位,却被你看成1位,错了啊,要用de的字符串来求长度*/
            //res+= (int) (ab*Math.pow(10,destr.length()));
            //上面👆这样写可以,但是直接像下面👇这样写不是更简单吗?
            res+= (int) (ab*Math.pow(10,nstr.length()-i-1));

            //System.out.println("ab"+ab+"c"+c+"de"+de);
            //System.out.println((int) (ab*Math.pow(10,getwei(de))));
            if(c==1){
                //System.out.println(de+1);
                if(destr.isEmpty()){res+=1;}//不要这个ifelse也行,要了更快
                else{
                    res+=de+1;/*[易错]  de = 32 那00-32都复合,所以要33个*/
                }
            }else if(c>1){
                //res+= (int) Math.pow(10,destr.length());
                res+= (int) Math.pow(10,nstr.length()-i-1);
                //System.out.println((int) Math.pow(10,getwei(de)));
            }
        }
        return res;
    }
//    private int getwei(int x){
//        if(x==-1)return 0;
//        if(x==0)return 1;
//        int res = 0;
//        while (x>0){
//            res++;
//            x/=10;
//        }
//        return res;
//    }
    //    作者：宫水三叶
//    链接：https://leetcode.cn/problems/number-of-digit-one/solutions/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * 人家答案写的看上去很简洁,其实是一样的
     * @param n
     * @return
     */
    public int countDigitOnev1(int n) {
        String nstr = String.valueOf(n);
        int m = nstr.length();
        if (m == 1) return n > 0 ? 1 : 0;
        // 计算第 i 位前缀代表的数值，和后缀代表的数值
        // 例如 abcde 则有 ab[2] = ab; de[2] = de
        int[] ab = new int[m];
        int[] de = new int[m];
        //ab[0] = 0 ; //截取空""
        de[0] = Integer.parseInt(nstr.substring(1));
        for (int i = 1; i < m - 1; i++) {
            ab[i] = Integer.parseInt(nstr.substring(0, i));
            de[i] = Integer.parseInt(nstr.substring(i + 1));
        }
        ab[m - 1] = Integer.parseInt(nstr.substring(0, m - 1));
        //de[m - 1] = 0; //截取空""
        // 分情况讨论
        int ans = 0;
        for (int i = 0; i < m; i++) {
            // x 为当前位数值，len 为当前位后面长度为多少
            int x = nstr.charAt(i) - '0';
            int len = m - i - 1;
            int prefix = ab[i], suffix = de[i];
            int tot = 0;
            tot += (int) (ab[i] * Math.pow(10, len));
            if (x == 0) {
            } else if (x == 1) {
                tot += de[i] + 1;
            } else {
                tot += (int) Math.pow(10, len);
            }
            ans += tot;
        }
        return ans;
    }
}

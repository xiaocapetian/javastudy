package leetcode;

public class l9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123321));
    }

    public static boolean isPalindrome(int x) {
        if(x<0){return false;}
        if(x==0){return true;}
        if(x%10==0){return false;}
        int shang = x;
        int yu = 0;
        int wei = 0;
        int zhuan = 0;
        while (zhuan<shang){
            yu = shang%10;
            shang = shang/10;
            zhuan = zhuan*10+yu;
            //wei++;
            System.out.println("yu= "+yu+" shang= "+shang+" zhuan= "+zhuan);
        }


        if(shang==zhuan){return true;}
        if(zhuan/10==shang){return true;}
        return false;
    }

        public boolean isPalindrome2(int x) {
            // 特殊情况：
            // 如上所述，当 x < 0 时，x 不是回文数。
            // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
            // 则其第一位数字也应该是 0
            // 只有 0 满足这一属性
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }

            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }

            // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
            // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
            // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
            return x == revertedNumber || x == revertedNumber / 10;
        }


//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/palindrome-number/solutions/281686/hui-wen-shu-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

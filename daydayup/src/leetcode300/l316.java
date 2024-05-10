package leetcode300;

public class l316 {

    public static String removeDuplicateLetters(String s) {

        int[] k = new int[26];
        for (int i = 0; i < s.length(); i++) {
            k[s.charAt(i)-'a']++;
        }
        boolean[] used = new boolean[26];
        //k[0] = 4;就代表一共会见到有4个,那就得删3个留1个
        //怎么单调栈啊?bcabc,bc到a的时候发现a比前两个小,且通过k[]得知bc后面还有,那就删bc
        //你要这么想,bcab ,那之后就没有c了,这个c必须保留吧,那c之前的比c小,肯定都不能替换成后辈了,(因为他们比c小啊!所以c和c之前,实际上就定下来了
        //
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //System.out.println("c="+c);
            if(!used[c-'a']){
                while (!sb.isEmpty()
                        &&sb.charAt(sb.length()-1)>c
                        &&k[sb.charAt(sb.length()-1)-'a']>0){//第一次见也会--,所以应该是>0,而不是>1

                    //System.out.println("sb.charAt(sb.length()-1)-'a'"+(sb.charAt(sb.length()-1)-'a'));
                    //System.out.println("sb.length()-1 = "+(sb.length()-1));
                    used[sb.charAt(sb.length()-1)-'a']=false;
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append(c);
                used[c-'a'] = true;
            }
            //System.out.println("sb = "+sb);
            k[s.charAt(i)-'a'] --;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }
    public static String removeDuplicateLetters0 (String s){
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            System.out.println("判断是否碰见过"+(ch));
            if (!vis[ch - 'a']) {
                //如果未曾遍历过

                //
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    System.out.println("栈顶的是:num["+(sb.charAt(sb.length() - 1) )+"]="+num[sb.charAt(sb.length() - 1) - 'a']);
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        System.out.println("它之后还有,可以删,我就当没有过"+sb.charAt(sb.length() - 1));
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        System.out.println("之后就没有"+sb.charAt(sb.length() - 1)+"了,不能删");
                        break;
                    }
                }

                vis[ch - 'a'] = true;
                sb.append(ch);
                System.out.println("sb="+sb);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/remove-duplicate-letters/solutions/527359/qu-chu-zhong-fu-zi-mu-by-leetcode-soluti-vuso/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}


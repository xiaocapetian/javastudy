package leetcode500;

import java.util.Arrays;
//只需要枚举字符串 s=strs[i]，判断 s 是否为其它字符串的子序列，如果不是，则用 s 的长度更新答案的最大值。
//不需要取s的子序列
public class l522v1 {
    public int findLUSlength(String[] strs) {

        Arrays.sort(strs, (o1, o2) -> {return o2.length()-o1.length();});
        //对于一个字符串str[i]，如果它不是任何其他(length()>=它的)strs[j]的子序列 就可以直接返回它的长度
        //如果它是某个strs[j]的子序列 那就不看他了，下一个
        //你可能会担心，那如果人家是它的子序列怎么办？ 丝毫不影响，
        for(int i = 0; i < strs.length; i++){
            boolean isUnique = true;
            for(int j = 0; j < strs.length; j++){
                if(i!=j&&strs[i].length()<=strs[j].length()&&ischild(strs[i],strs[j])){

                    isUnique = false;
                    break;
                }
            }
            if(isUnique){return strs[i].length();}
        }
        return -1;
    }
    /**
     * str1是 str2的子序列吗？
     */
    private boolean ischild(String str1, String str2) {
        int item2 = 0;
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            //System.out.println("i="+i+",c ="+c);
            while (item2<str2.length() && c != str2.charAt(item2)) {
                //System.out.println("item2="+item2);
                item2++;
            }

            if(item2==str2.length()){return false;}
            item2++;
        }
        return true;
    }
}

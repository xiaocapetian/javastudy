package leetcode;
//用时极其长
public class l14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        if(strs.length==1)return strs[0];



        StringBuilder sb2 = new StringBuilder();
        sb2.append(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            int i1 = 0;
            for (; i1 < Math.min(strs[i].length(),sb2.length()); i1++) {
                if(strs[i].charAt(i1)==sb2.toString().charAt(i1)){
                }else {
                    break;
                }
            }
            sb2.delete(i1,sb2.length());
            if(sb2.isEmpty()){return "";}
        }

        return sb2.toString();

    }
}

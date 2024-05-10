package mst;

public class m0106 {
    public String compressString(String S) {
        //我厉害啊我居然一遍过了
        StringBuilder sb =new StringBuilder();
        int i = 0;
        char[] sarr = S.toCharArray();
        while (i<S.length()){
            int count = 0;
            while (count==0||(i<S.length()&&sarr[i]==sarr[i-1])){//这个和什么像啊,和那个回溯很像啊!!!
                i++;
                count++;
            }
            sb.append(sarr[i-1]).append(count);
        }
        if(sb.toString().length()>=S.length())return S;
        else {
            return sb.toString();
        }
    }
}

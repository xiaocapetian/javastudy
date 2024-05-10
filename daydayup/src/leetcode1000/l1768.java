package leetcode1000;

public class l1768 {
    //瞧瞧什么叫简单
    String mergeAlternately2(String word1, String word2) {
        int len1  = word1.length();
        int len2 = word2.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i <len1||i<len2){
            if(i < len1 ){
                sb.append(word1.charAt(i));
            }
            if(i < len2){
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
    //自己写复杂了啊
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int item = 0;
        if(len1>len2){
            while (item<word2.length()){
                sb.append(word1.charAt(item));
                sb.append(word2.charAt(item));
                item++;
            }
            while (item<word1.length()){
                sb.append(word1.charAt(item));item++;
            }
        }else {
            while (item<word1.length()){
                sb.append(word1.charAt(item));
                sb.append(word2.charAt(item));
                item++;
            }
            while (item<word2.length()){
                sb.append(word2.charAt(item));item++;
            }
        }
        return sb.toString();

    }

}

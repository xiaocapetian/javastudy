package leetcode500;

public class l541 {

    /**
     * 调试时间长,速度慢  写这么多干什么,学学v1!!
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        //字符串翻转题,sb太慢了  用数组
        StringBuilder sb = new StringBuilder();
        int num2k=s.length()/(2*k);
        int count2k = 0;
        //System.out.println(num2k);
        for(int i = 0;i<2*k*num2k;i++){
            if(i%(2*k)==0){
                //int left = count2k*2*k;
                //int right = count2k*2*k+k;

                for(int right = count2k*2*k+k-1;right>= count2k*2*k;right--){
                    sb.append(s.charAt(right));
                }
                for (int item = count2k*2*k+k;item<count2k*2*k+k*2;item++){
                    sb.append(s.charAt(item));
                }
                count2k++;
            }

        }
        if(s.length()-2*k*num2k<k){
            for(int right = s.length()-1;right>= num2k*2*k;right--){
                sb.append(s.charAt(right));
            }

        }
        if(s.length()-2*k*num2k>=k){
            for(int right = num2k*2*k+k-1;right>= num2k*2*k;right--){
                sb.append(s.charAt(right));
            }
            for (int item = num2k*2*k+k;item<s.length();item++){
                sb.append(s.charAt(item));
            }

        }

        return sb.toString();
    }

}

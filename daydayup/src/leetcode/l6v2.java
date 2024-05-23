package leetcode;

/**5.20再刷
 * 这题写了好久啊，其实这个思路应该没啥问题，就是写的太慢了
 */
public class l6v2 {
    public String convert(String s, int numRows) {

        if(numRows==1)return s;//必须要这样 如果numRows==1 k=0是不行的
        int k = 2*(numRows-1);
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<=k/2;i++){//从第0行到第k/2行
            for(int j=0;j*k+i<s.length();j++){
                //竖线那一列是j*k+i
                sb.append(s.charAt(j*k+i));
                //斜线那一列是j*k+k-i
                //如果不是第0行或k/2行（首尾）
                if( i!=0 && i!=k/2 && j*k+k-i<s.length()){
                    sb.append(s.charAt(j*k+k-i));
                }
            }
        }

        return sb.toString();
    }
}

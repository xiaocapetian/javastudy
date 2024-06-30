package leetcode;

public class l91 {
    public int numDecodings(String s) {

        int[][] bp= new int[s.length()][2];
        if(s.charAt(0)=='0'){
            return 0;
        }
        bp[0][0]=1;
        bp[0][1]=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'){
                //把这个单独提出来
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    bp[i][1] = bp[i-1][0];
                    bp[i][0] = 0;
                }else {
                    return 0;
                }
            }else {
                bp[i][0]=bp[i-1][0]+bp[i-1][1];
                //下面填bp[i][1].也就是能和上一位组成合格的2位数 10-19 20-26
                if(s.charAt(i-1)=='1'){bp[i][1]=bp[i-1][0];}
                else if(s.charAt(i-1)=='2'&&s.charAt(i)-'6'<=0){
                    bp[i][1]=bp[i-1][0];
                }else {
                    bp[i][1]=0;
                }
            }

        }
        //         for (int i = 0; i < bp.length; i++) {
        //     System.out.println(Arrays.toString(bp[i]));
        // }
        return bp[s.length()-1][0]+bp[s.length()-1][1];
    }
}

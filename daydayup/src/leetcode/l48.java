package leetcode;

public class l48 {
    public void rotate(int[][] matrix) {
//和54一样,我又梅开二度了
        //int jie = matrix.length/2+matrix.length%2;
        int left =  0;
        int right = matrix[0].length-1;
        int shang = 0;
        int xia= matrix.length-1;
        while (shang <xia){
            for(int i = 0;i<xia-shang;i++){
                int temp = matrix[shang][left+i];
                matrix[shang][left+i] = matrix[xia-i][left];
                matrix[xia-i][left] = matrix[xia][right-i];
                matrix[xia][right-i] = matrix[shang+i][right];
                matrix[shang+i][right] = temp;
            }
            right--;xia--;shang++;left++;
        }

    }
}

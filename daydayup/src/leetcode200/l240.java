package leetcode200;

public class l240 {
    //所谓z字查找,其实不用递归了
    public boolean searchMatrix4(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length-1;

        while (x<matrix.length&&y>=0){
            if(matrix[x][y]==target){
                return true;
            }
            if(matrix[x][y]<target){
                x++;
                //return zfind(matrix,x+1,y,target);
            }else {
                y--;
            }
        }
        return false;
    }
    //从右上角到左下角,所谓z字查找
    public boolean searchMatrix3(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length-1;

        return zfind(matrix,x,y,target);
    }
    public boolean zfind(int[][] matrix,int x,int y,int target){
        if(matrix[x][y]==target){
            return true;
        }
        if(matrix[x][y]<target){
            return x+1>matrix.length?false:zfind(matrix,x+1,y,target);
            //return zfind(matrix,x+1,y,target);
        }else {
            return y-1<0?false:zfind(matrix,x,y-1,target);
        }

    }
    //自己写的超时了
    /**
     * 我回看一下,现在的我都想不出这个思路了我抄😭了
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return find(matrix,target,0,0);
    }
    public boolean find(int[][] matrix,int target,int x,int y){
        if(matrix[x][y]==target){return true;}
        if(matrix[x][y]>target){return false;}
        boolean xia = false;
        boolean you = false;
        if(x+1<matrix.length){
            xia = find(matrix,target,x+1,y);
        }
        if(y+1<matrix[0].length){
            you = find(matrix,target,x,y+1);
        }
        return xia||you;
    }
//我破防了还不如直接两个for
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int element : row) {
                if (element == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /*这题又忘了，看完再写一遍，
    二维数组找值,从右上到左下z字形走位（就非常简单了）
     */
    public boolean findTargetIn2DPlants5(int[][] matrix, int target) {
        if (matrix==null||matrix.length ==0){return false;}
        int x=0;
        int y = matrix[0].length-1;
        while (x<matrix.length&&y>=0){
            if(matrix[x][y]==target){return true;}
            else if(matrix[x][y]>target){
                y++;
            }else {
                x--;
            }
        }
        return false;
    }

}

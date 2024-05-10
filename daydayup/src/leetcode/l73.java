package leetcode;

public class l73 {
    public void setZeroes(int[][] matrix) {
//设置两个标记数组分别记录每一行和每一列是否有零出现。
        boolean[] lie = new boolean[matrix[0].length];
        boolean[] hang = new boolean[matrix.length];
//第一次遍历
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    hang[i] = true;
                    lie[j] = true;

                }
            }
        }
        //第二次遍历
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                if(hang[i]==true||lie[j]==true){
                    matrix[i][j]=0;
                }
            }}
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l54 {
    public List<Integer> spiralOrder(int[][] matrix) {
//m 行 n 列

        List<Integer> res = new ArrayList<>();
        //for(int lun = 0;)
        //
        int shang = 0;
        int xia = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while (right>left&&xia>shang){
            for(int i = left;i<right;i++){
                res.add(matrix[shang][i]);
            }
            for(int j = shang;j<xia;j++){
                res.add(matrix[j][right]);
            }
            for(int i = right;i>left;i--){
                res.add(matrix[xia][i]);
            }
            for(int j = xia;j>shang;j--){
                res.add(matrix[j][left]);
            }
            right--;xia--;shang++;left++;
        }
        //最后执行一波上下
        if(left==right){
            for(int j = shang;j<=xia;j++){
                res.add(matrix[j][right]);
            }
        }else if(shang==xia){
            for(int i = left;i<=right;i++){
                res.add(matrix[shang][i]);
            }
        }
        return res;
    }
}

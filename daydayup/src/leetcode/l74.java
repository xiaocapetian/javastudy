package leetcode;

public class l74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target<matrix[0][0]){
            return false;
        }
        int high = matrix.length;
        int wide = matrix[0].length;
        int left = 0;
        int right = high-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(matrix[mid][0]==target){return true;}
            else if(matrix[mid][0]<target){
                left = mid+1;
            }
            else {
                right = mid-1;
            }

        }
        //left-1行
        int left2 = 0;
        int right2 = wide-1;
        while (left2<=right2){
            int mid = (left2+right2)/2;
            if(matrix[left-1][mid]==target){return true;}
            else if(matrix[left-1][mid]<target){
                left2 = mid+1;
            }
            else {
                right2 = mid-1;
            }

        }
        return false;

    }
}

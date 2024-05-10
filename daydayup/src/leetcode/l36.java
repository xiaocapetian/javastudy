package leetcode;

public class l36 {
    public boolean isValidSudoku(char[][] board) {
        //三个数组
        //最后一个位0-9数字  ,前一两位是位置
        //可以用哈希表做的，但是它大小是确定的9，所以可以用二维数组代替
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.'){continue;}
                int dex = board[i][j]-'0'-1;//记住这里要-1
                rows[j][dex]++;
                columns[i][dex]++;
                subboxes[i/3][j/3][dex]++;
                if(rows[j][dex]>1||columns[i][dex]>1||subboxes[i/3][j/3][dex]>1)return false;
            }
        }
        return true;
    }
}

package leetcode;

public class l59 {
    //全自己写的,我真厉害啊!;
    //我的思路是遇到不是0的才能覆盖
    public static void main(String[] args) {
        int[][] res = generateMatrix(4);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int x = 0,y = -1,item = 0,yuan = n;
        while (yuan>0) {
            while (y < n - 1 && res[x][y + 1] == 0) {
                item++;
                y++;
                res[x][y] = item;
            }
            while (x < n - 1 && res[x + 1][y] == 0) {
                item++;
                x++;
                res[x][y] = item;
            }
            while (y > 0 && res[x][y - 1] == 0) {
                item++;
                y--;
                res[x][y] = item;
            }
            while (x > 0 && res[x - 1][y] == 0) {
                item++;
                x--;
                res[x][y] = item;
            }
            yuan=yuan-2;
        }
        return res;
    }
}

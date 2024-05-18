package leetcode500;

/**
 * 简单,速通了
 */
public class l547 {
    boolean[] isvisited;
    /**
     * @param isConnected 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
     *                    而 isConnected[i][j] = 0 表示二者不直接相连。
     * @return 返回矩阵中 省份 的数量。
     */
    public int findCircleNum(int[][] isConnected) {

        isvisited = new boolean[isConnected.length];

        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            //现在遍历城市i
            if(!isvisited[i]){
                 count++;
                find(isConnected,i);}
        }
        return count;
    }

    private void find(int[][] isConnected, int i) {
        isvisited[i] = true;
        for (int j = 0; j < isConnected[i].length; j++) {
            if(!isvisited[j]&&isConnected[i][j]==1){
                find(isConnected,j);}
        }
    }
}

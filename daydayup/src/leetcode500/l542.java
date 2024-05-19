package leetcode500;

import java.util.LinkedList;
import java.util.Queue;

/**瞅了一眼思路自己写的
 * 图的广度优先搜索!想想二叉树的😀层序😀遍历!   在图这儿,换成多源的(就是第一轮要塞很多头节点进队列嘛),且要记录一下是否访问过
 */
public class l542 {
    /**
     *
     * @param mat 给定一个由 0 和 1 组成的矩阵 mat ，
     * @return 请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
     */
    public int[][] updateMatrix(int[][] mat) {

        int[][] res = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<Zuobiao> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j]==0){
                    queue.add(new Zuobiao(i,j));
                    visited[i][j] = true;
                }
            }
        }
        int count=0;
        while (!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0;i<size;i++){
                Zuobiao poll = queue.poll();
                res[poll.x][poll.y] = count;
                int x =poll.x;
                int y =poll.y;
                if(isValid(x,y+1,mat)&&!visited[x][y+1]){
                    visited[x][y+1] =true;
                    queue.add(new Zuobiao(x,y+1));
                }
                if(isValid(x,y-1,mat)&&!visited[x][y-1]){
                    visited[x][y-1] =true;
                    queue.add(new Zuobiao(x,y-1));
                }
                if(isValid(x+1,y,mat)&&!visited[x+1][y]){
                    visited[x+1][y] =true;
                    queue.add(new Zuobiao(x+1,y));
                }
                if(isValid(x-1,y,mat)&&!visited[x-1][y]){
                    visited[x-1][y] =true;
                    queue.add(new Zuobiao(x-1,y));
                }
            }
            count++;
        }
        return res;
    }
    public boolean isValid(int x,int y,int[][] mat){
        if(y<0||x<0||y>=mat[0].length||x>=mat.length){
            return false;
        }
        return true;
    }
    class Zuobiao{
        int x;
        int y;
        Zuobiao(int x ,int y){
            this.x = x;
            this.y = y;
        }
    }
}

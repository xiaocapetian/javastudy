package leetcode500;

import java.util.ArrayList;
import java.util.List;

public class l529 {
    /**
     * 扫雷游戏
     * @param board
     * 未挖出
      'M' 代表一个 未挖出的 地雷，
      'E' 代表一个 未挖出的 空方块，
     * 已挖出
       'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的 已挖出的 空白方块，
       数字（'1' 到 '8'）表示有多少地雷与这块 已挖出的 方块相邻，
       'X' 则表示一个 已挖出的 地雷。
     * @param click 给你一个整数数组 click ，其中 click = [clickr, clickc] 表示在所有 未挖出的 方块（'M' 或者 'E'）中的下一个点击位置
     *              （clickr 是行下标，clickc 是列下标）。
     * @return 根据以下规则，返回相应位置被点击后对应的盘面：
     * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X' 。
     * 如果一个 没有相邻地雷 的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的 未挖出 方块都应该被递归地揭露。
     * 如果一个 至少与一个地雷相邻 的空方块（'E'）被挖出，修改它为数字（'1' 到 '8' ），表示相邻地雷的数量。
     * 如果在此次点击中，若无更多方块可被揭露，则返回盘面。
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        return update(board,click[0],click[1]);

    }

    private char[][] update(char[][] board, int clickx, int clicky) {
        if(board[clickx][clicky] == 'M'){
            board[clickx][clicky] = 'X';
            return board;
        }
        if(board[clickx][clicky] != 'E'){
            return board;
        }
        int num = numBoomNeighbor(board,clickx,clicky);
        if(num==0){
            board[clickx][clicky] = 'B';
            List<int[]> neighbors = findNeighbor(board, clickx, clicky);
            for (int[] neighbor : neighbors) {
                if(board[neighbor[0]][neighbor[1]]=='M'||board[neighbor[0]][neighbor[1]]=='E'){
                    board = update(board, neighbor[0], neighbor[1]);
                }

            }
        }else {
            board[clickx][clicky] = (char) (num+'0');
        }
        return board;
    }

    private int numBoomNeighbor(char[][] board, int clickx, int clicky) {
        int num = 0 ;
        List<int[]> neighbors = findNeighbor(board, clickx, clicky);
        for (int[] ints : neighbors) {
            if(board[ints[0]][ints[1]]=='M'||board[ints[0]][ints[1]]=='X'){num++;}
        }
        return num;
    }
    private List<int[]> findNeighbor(char[][] board, int clickx, int clicky){
        List<int[]> res = new ArrayList<>();
        if(clickx-1>=0&&clicky-1>=0){res.add(new int[]{clickx-1,clicky-1});}
        if(clickx-1>=0){res.add(new int[]{clickx-1,clicky});}
        if(clickx-1>=0&&clicky+1<board[0].length){res.add(new int[]{clickx-1,clicky+1});}

        if(clickx+1<board.length&&clicky-1>=0){res.add(new int[]{clickx+1,clicky-1});}
        if(clickx+1<board.length){res.add(new int[]{clickx+1,clicky});}
        if(clickx+1<board.length&&clicky+1<board[0].length){res.add(new int[]{clickx+1,clicky+1});}

        if (clicky-1>=0){res.add(new int[]{clickx,clicky-1});}
        if (clicky+1<board[0].length){res.add(new int[]{clickx,clicky+1});}
        return res;
    }
}

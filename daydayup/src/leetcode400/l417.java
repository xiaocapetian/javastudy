package leetcode400;

import java.util.ArrayList;
import java.util.List;

/**
 * 只要想到是图论,会做之后其实不难吧!
 */
public class l417 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] zuoshangsea = new boolean[heights.length][heights[0].length];
        boolean[][] youxiasea = new boolean[heights.length][heights[0].length];
        for(int i = 0;i<heights.length;i++){
            dfs(heights,i,0,zuoshangsea);
        }
        for(int j = 0;j<heights[0].length;j++){
            dfs(heights,0,j,zuoshangsea);
        }
        for(int i = 0;i<heights.length;i++){
            dfs(heights,i,heights[0].length-1,youxiasea);
        }
        for(int j = 0;j<heights[0].length;j++){
            dfs(heights,heights.length-1,j,youxiasea);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<heights.length;i++) {
            for (int j = 0; j < heights[0].length; j++) {

                if(zuoshangsea[i][j]&&youxiasea[i][j]){
                    List<Integer> zuobiao =new ArrayList<>();
                    zuobiao.add(i);
                    zuobiao.add(j);
                    res.add(zuobiao);
                }
            }
        }
        return res;
    }
    private void dfs(int[][] heights,int x,int y,boolean[][] sea){
        //if(!isvalid(x,y,heights))return;
        if(sea[x][y])return;
        sea[x][y]=true;

        if(isvalid(x-1,y,heights)&&heights[x-1][y]>=heights[x][y])dfs(heights,x-1,y,sea);
        if(isvalid(x,y-1,heights)&&heights[x][y-1]>=heights[x][y])dfs(heights,x,y-1,sea);
        if(isvalid(x+1,y,heights)&&heights[x+1][y]>=heights[x][y])dfs(heights,x+1,y,sea);
        if(isvalid(x,y+1,heights)&&heights[x][y+1]>=heights[x][y])dfs(heights,x,y+1,sea);
    }
    private boolean isvalid(int x,int y,int[][] heights){
        if(x<0||y<0||x>=heights.length||y>=heights[0].length)return false;
        return true;
    }
}

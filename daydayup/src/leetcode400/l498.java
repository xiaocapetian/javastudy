package leetcode400;

/**
 * 自己写的呀!
 */
public class l498 {
    public int[] findDiagonalOrder(int[][] mat) {

        int[] res =new int[mat.length*mat[0].length];
        fill(mat,0,0,0,res,true);
        return res;
    }

    private void fill(int[][] mat,int step,int x, int y, int[] res,boolean rightUp) {
//System.out.println("x="+x+" y="+y);
        if(step==res.length) return;
        res[step] = mat[x][y];
        if(rightUp){
            if(x==0&&y<mat[x].length-1){  /*[难点]    若同时有x==0且y==mat[x].length-1还行应该走后者才是更重要的*/
                fill(mat,step+1,0,y+1,res,false);
            }else if(y==mat[x].length-1){  /*[难点]不仅要考虑x==0 了这前半段的转向, 还要考虑y==mat[x].length-1了这后半段的转向*/
                fill(mat,step+1,x+1,y,res,false);
            }else {
                fill(mat,step+1,x-1,y+1,res,true);
            }
        }else {
            if(y==0&&x<mat.length-1){
                fill(mat,step+1,x+1,0,res,true);
            }else if(x==mat.length-1){
                fill(mat,step+1,x,y+1,res,true);
            }else {
                fill(mat,step+1,x+1,y-1,res,false);
            }
        }
    }
}

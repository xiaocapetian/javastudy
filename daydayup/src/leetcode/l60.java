package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 难炸了我抄
 *
 * [重难点],一次性找到直接 return,不回溯!那也不用判断左了
 */
public class l60 {
    static int[] jiecheng = new int[]{
            1,1,2,2*3,2*3*4,2*3*4*5, 2*3*4*5*6, 2*3*4*5*6*7,2*3*4*5*6*7* 8,2*3*4*5*6*7* 8*9
    };/*易错1.这里0的界乘如果写成0,再最后阶数到0的时候计算fR-jiecheng[jieshu]减不开,因为算的是(fl,fR]左开右闭导致加不进去*/
    String res;
    public String getPermutation(int n, int k) {

        int[] num = new int[n];
        for (int i = 0; i < num.length; i++) {
            num[i] = i+1;
        }
        boolean[] used = new boolean[n];
        backtrack(num,n,k,new ArrayList<>() ,used,1,jiecheng[n]);
        return res;
    }

    private void backtrack(int[] num,int n,int k,List<Integer> path,boolean[] used, int cenci,int fanweiRight) {
        //System.out.println("fanweiR="+fanweiRight);
        //System.out.println("path="+path);
        if(path.size()==n){
            StringBuilder sb =new StringBuilder();
            for (Integer i : path) {
                sb.append(i);
            }
            res = sb.toString();
            return;
        }
        int jieshu = n-cenci;
        //System.out.print("cenci="+cenci);
        //System.out.print("jieshu="+jieshu);
        //System.out.println("   jiecheng[jieshu]="+jiecheng[jieshu]);

        int ceni = 0;
        for(int i = 0;i<num.length;i++){
            if(used[i]){continue;}

            //int fanweiLeft = (i-1)*jiecheng[jieshu];
            int fR =fanweiRight- (n-ceni-cenci)*jiecheng[jieshu];/*[易错2]这里要新算一个fR,而fanweiRight是这一层所共有的*/
            /*[易错3] - (n-ceni-cenci)*jiecheng 这里要定义一个ceni ,而不是 i 因为i因为去重的缘故不准确*/
            /*[易错4] - (n-ceni-cenci)*jiecheng 这里减的是-cenci 而不是减1*/
            //System.out.println("i="+i+"ceni"+ceni);
            //System.out.println("fanweiRight ="+fanweiRight);
            //System.out.println("fR ="+fR+"   fl ="+(fR-jiecheng[jieshu]));
            ceni++;
            if(k>fR||k<=fR-jiecheng[jieshu]){continue;}
            /*[易错5] 这里不仅要有右,还要有左 ,不然回溯中会覆盖掉我们的结果*/
            path.add(num[i]);
            used[i] = true;
            backtrack(num,n,k,path,used,cenci+1,fR);
            return;
            //path.remove(path.size()-1);
            //used[i] = false;
            /*[重难点],一次性找到直接 return,不回溯!那也不用判断左了*/
        }
    }

}

package leetcode;

import java.util.Arrays;

/**
 * 自己根据l42v2的方法写的
 * [难点]对于每一个位置,得保存一个第一个比它值小的下标,leftmin[5] = 3;代表对于5号位,3号位是第一个比他小的
 * 策略就是,不找比自己小的,只按自己的高度作为最低高度
 */
public class l84v1 {

    public static void main(String[] args) {
        l84v1 s = new l84v1();
        int[] heights=new int[]{2,1,5,6,2,3};
        s.largestRectangleArea(heights);
    }
    public int largestRectangleArea(int[] heights) {
        /*[难点]这里需要左右扩容,l42v2那里不需要,但是这里还是扩容一下*/
        int[] newheights = new int[heights.length+2];
        for (int i = 1; i < newheights.length-1; i++) {
            newheights[i] = heights[i-1];
        }
        //System.out.println(Arrays.toString(newheights));
        //对于每一个位置,得保存一个第一个比它值小的下标,leftmin[5] = 3;代表对于5号位,3号位是第一个比他小的
        int[] leftmin = new int[newheights.length];
        int[] rightmin = new int[newheights.length];
        //leftmin[0]=0 我肯定知道leftmin[1]=0
        for (int i = 1; i < leftmin.length-1; i++) {

            int wangzuozhao = i-1;
            while (wangzuozhao>0&&newheights[wangzuozhao]>=newheights[i]){/*[易错]如果真给你一个0,那这里就跳不出去了,所以必须判>0 */
                wangzuozhao = leftmin[wangzuozhao];
            }
            //while (wangzuozhao>=0&&newheights[wangzuozhao]>=newheights[i]){wangzuozhao--;}
            leftmin[i] = wangzuozhao;
            //System.out.println(Arrays.toString(leftmin));
        }
        for (int i = leftmin.length-2; i >0 ; i--) {
            int wangyouzhao = i+1;
            while (wangyouzhao<leftmin.length-1&&newheights[wangyouzhao]>=newheights[i]){
                wangyouzhao = rightmin[wangyouzhao];
            }
            //while (wangyouzhao<newheights.length&&newheights[wangyouzhao]>=newheights[i]){wangyouzhao++;}
            rightmin[i] = wangyouzhao;
        }
        //System.out.println(Arrays.toString(leftmin));
        //System.out.println(Arrays.toString(rightmin));
        int res = 0;
        for (int i = 0; i < newheights.length; i++) {
            int area = (rightmin[i]-leftmin[i]-1)*newheights[i];
            /*[易错] (rightmin[i]-leftmin[i]-1)宽度这里,*/
            //System.out.println("area = ("+rightmin[i]+" - "+leftmin[i] +"-1)  *"+newheights[i]+" = "+area);
            res = Math.max(res,area);
        }
        return res;
//        int left;
//        int right;
    }
}

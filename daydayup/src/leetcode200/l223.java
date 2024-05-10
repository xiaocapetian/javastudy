package leetcode200;

public class l223 {
    /**
     * 小学生题吧,,
     * @param ax1  第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
     * @param ay1
     * @param ax2
     * @param ay2
     * @param bx1  第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
     * @param by1
     * @param bx2
     * @param by2
     * @return 给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int s1 = (ax2-ax1)*(ay2-ay1);
        int s2 = (bx2-bx1)*(by2-by1);
        int shang = Math.min(ay2,by2);
        int xia = Math.max(ay1,by1);

        int right = Math.min(ax2,bx2);
        int left = Math.max(ax1,bx1);
        if(xia>shang||left>right){return s1+s2;}
        return s1+s2-(shang-xia)*(right-left);
    }
}

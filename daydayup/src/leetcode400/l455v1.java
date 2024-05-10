package leetcode400;

import java.util.Arrays;

public class l455v1 {
    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};
        System.out.println(findContentChildren(g,s));

    }
    //尝试自己写,写的太复杂
    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);//孩子排序
        Arrays.sort(s);//饼干排序
        //我只要让最小的饼干给符合要求的最小的孩子,
        int childItem = 0;
        /*为什么太复杂,问题出在我外循环是饼干?那v2我外循环小孩试一试
        * 但我现在感觉问题在我应该从大到小,先试试最大的饼干
        * v1思路 对最小的饼干,试最小的小孩,若不可以,饼干前移,直到可以
        * v2思路,对最大的小孩,试最大的饼干,若可以,饼干前移 ,无论可不可以,小孩前移
        * v3思路,把v2的反过来,对最小的小孩,用最小的饼干,但是这时候就复杂一步,如果不可以,是要饼干一直后移直到满足
        * 再饼干后移,小孩后移
        *
        * 综上,v2思路最简单!
        * */
        for (int cookieItem = 0; cookieItem < s.length; cookieItem++) {
            while (cookieItem < s.length&&childItem<g.length&&s[cookieItem]<g[childItem]){
                cookieItem++;
            }
            if(cookieItem==s.length){
                System.out.println("饼干分完了");
                return childItem;
            }else if(childItem== g.length){
                System.out.println("孩子都有了");
                return childItem;
            }
            else{
                System.out.println("孩子编号"+childItem+"要求"+ g[childItem]
                        +"分到了饼干编号"+cookieItem+"饼干大小"+s[cookieItem]);
                childItem++;

            }

        }

        return childItem;
    }
}

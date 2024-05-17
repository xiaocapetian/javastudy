package leetcode300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l354 {
    /*这题太高级了,想到排序+动态规划只是第一步啊
    怎么降低维度,
    对o1[0]升序排序之后,若不考虑<=,只有<.那么问题转化为递增子序列l300题
    那怎么排除掉=,只有<呢?  对o1[1]进行升序!!!
    这样只要o1[1]<o2[1],一定存在o1[0]<o2[0]
    (因为只要o1[0]==o2[0],一定不会o1[1]>o2[1]---因为在o1[0]==o2[0]时,已经o1[1]进行升序了)*/

    /**
     * @param envelopes 二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
     * @return 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     */
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes,(o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];//真的秀啊
            }
        });
        //此后看来就是对envelopes[i][1]做l300的事了,但是还要二分动规!

        //int[][] bp = new int[envelopes.length][envelopes.length];
        //这个bp的定义非常之秀:bp[i][j]是 前i个元素可组成的长度为j的 ↗子序列 末尾元素的 最小值
        //而且还必须要再压缩成一维的👇
        int[] bp = new int[envelopes.length];
        int maxbp = 0;
        int item = -1;//有值的坐标       也就是说这个bp只有[0,item]前一段是有值的
        // [注意:这里要写-1,不可以写0!!!因为最开始插入的值看来有值的坐标是-1]
        //bp[posi]表示的是长度为posi子串的最小值末尾节点值
        //[bp是怎么更新的]有难度,但是可以搞懂,画图理解一下!!!

        for (int i = 0; i < bp.length; i++) {
            //现在遍历到i了,那我要在bp中对envelopes[i][1],做二分查找
            int target = envelopes[i][1];
            int position = erfen(target, bp, item);
            //找到它应该放的位置是position
            //System.out.println("position"+position);
            //System.out.println(Arrays.toString(bp));

            bp[position] = envelopes[i][1];
            //这里实际上分两种情况(合二为一了),情况1,position=item+1,也就是envelopes[i][1]比现在bp里的任何都大,
            //那bp[position] = envelopes[i][1];相当于开辟了一个新位置
            //情况2,position在0,item中找到了一个归宿,那他应该覆盖这个位置1,2,4,5->1,2,3,5代表以后3位最小值是3了,不用是4了
            //那么这里也是两种情况(合二为一了)
            item = Math.max(item,position);
        }

        return item+1;

    }

    /**
     * @param target 找谁?找target
     * @param bp 对谁做二分查找?对bp做,为什么可以对bp做,因为它的单增的
     * @param item 找的是从0到item
     * @return
     */
    private int erfen(int target, int[] bp, int item) {
        int left = 0;
        int right = item;//左闭右闭
        while (left<=right){
            int mid = (left+right)/2;
            if(target== bp[mid]){
                return mid;
            }
            else if(target< bp[mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;//二分查找返回left,要么是它的位置,要么是它应该替代的位置
    }


    //应该是对的,但是超时,咱的思路没问题哈,先排序,再动规    -- 其实还早着呢
    public int maxEnvelopesv1(int[][] envelopes) {


        List<int[]> envelopesList = new ArrayList<>();
        Collections.addAll(envelopesList,envelopes);
        List<int[]> eList = envelopesList.stream().sorted((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        }).toList();
        int[] bp = new int[envelopes.length];
        int maxbp = 0;
        for (int i = 0; i < bp.length; i++) {

            int max = 1;
            for(int j = 0 ;j<i;j++){
                if(eList.get(j)[0]<eList.get(i)[0]&&eList.get(j)[1]<eList.get(i)[1]){
                    max = Math.max(max,bp[j]+1);
                }
            }
            bp[i] = max;
            maxbp = Math.max(maxbp,bp[i]);
        }
        // for (int[] ints : eList) {
        //     System.out.println(Arrays.toString(ints));
        // }
        // System.out.println(Arrays.toString(bp));
        return maxbp;

    }

}

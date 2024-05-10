package leetcode600;

/**
 * [难点1],定义一个right[],right[i]表示i右侧最大值的位置(包括自己)
 * [难点2]怎么获得这个right[]?倒着遍历就可以了!
 */
public class l670 {
    /**
     *
     * @param num 给定一个非负整数，你至多可以交换一次数字中的任意两位。
     * @return 返回你能得到的最大值。
     */
    public int maximumSwap(int num) {
        //只有1个最大值2736 最大值换到最高位
        //多个最大值 2776 最后一个最大值换到最高位
        //最高位就是最大值,对第二位采取上述操作

        String numstr = num + "";
        char[] numarr = numstr.toCharArray();
        //String[] numarr = numstr.split(" "); //我看你真是糊涂了
        //int nn = num;

        /* [难点1],定义一个right[],right[i]表示i右侧最大值的位置(包括自己) */
        int[] right = new int[numstr.length()];
        /*[难点2]怎么获得这个right[]?倒着遍历就可以了!*/
        right[right.length-1] = right.length-1;
        for (int i = right.length-2; i >= 0; i--) {
            //要么就是它这一位,要么就是后一位记录的最大值
            right[i] = numarr[i]<=numarr[right[i+1]]?right[i+1]:i;
        }
        int i = 0;
        while (i!=numstr.length()&&numarr[right[i]]==numarr[i]){   /*[易错]这里别超范围了*/
            i++;
        }
        if(i!=numstr.length()){
            char temp = numarr[i];
            numarr[i] = numarr[right[i]];
            numarr[right[i]] = temp;
        }
        String res =new String(numarr);
        return Integer.parseInt(res);
//        StringBuilder sb = new StringBuilder();
//        for (int i1 = 0; i1 < numarr.length; i1++) {
//            sb.append(numarr[i1]);
//        }
//        System.out.println(Arrays.toString(right));
        //return Integer.parseInt(sb.toString());

    }
}

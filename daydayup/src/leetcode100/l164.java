package leetcode100;

import java.util.Arrays;

/**
 * [重点]一个buf[],一个cnt[]
 * [易错],第二轮遍历nums,填buf[]时,一定要倒着遍历
 */
public class l164 {
    public static void main(String[] args) {
        //int[] nums = new int[]{3,6,9,1};
        int[] nums = new int[]{13,26,19,31,21};
        l164 solution = new l164();
        solution.maximumGap(nums);
    }
    //基数排序
    public int maximumGap(int[] nums) {
        //int n = nums.length;
        if (nums.length < 2) {
            return 0;
        }
        //radixSort(nums);
        radixSortTry(nums);
        //System.out.println(Arrays.toString(nums));
        int ret = 0;
        for (int i = 1; i < nums.length; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }

    /**
     * 基数排序
     * @param nums
     */
    private static void radixSort(int[] nums) {
        long exp = 1;
        int[] buf = new int[nums.length];
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp) {
            //System.out.println("exp="+exp);
            int[] cnt = new int[10];
            for (int i = 0; i < nums.length; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            //个位桶有几个就有几个
            //System.out.println(Arrays.toString(cnt));

            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            //本筒至之前的筒共有几个就有几个(其中不后面平的部分不重要,重要的是有增的部分,代表它之后放进哪个筒
            //System.out.println("cnt = "+Arrays.toString(cnt));

            for (int i = nums.length - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                System.out.println("i="+i+" nums[i]="+ nums[i]+" ,digit="+digit);

                buf[cnt[digit]-1] = nums[i];
                System.out.println("  cnt[digit]="+cnt[digit] +"  buf["+(cnt[digit]) +"]="+ nums[i]);
                cnt[digit]--;//放进去一个,这里就--

            }

            System.out.println("cnt"+Arrays.toString(cnt));
            System.out.println("buf"+Arrays.toString(buf));//buf就是按某位排之后的结果
            System.arraycopy(buf, 0, nums, 0, nums.length);
            exp *= 10;
        }
    }

    private static void radixSortTry(int[] nums) {
        int exp = 1;
        int max = Arrays.stream(nums).max().getAsInt();
        while (exp<=max){
            //一个buf[]暂存,一个cns[]
            int[] buf = new int[nums.length];
            int[] cns = new int[10];
            for (int i = 0; i < nums.length; i++) {
                int digit = nums[i]/exp%10;
                cns[digit] ++;
            }
            for (int i = 1; i < cns.length; i++) {
                cns[i] +=cns[i-1];
            }
            System.out.println(Arrays.toString(nums));
            System.out.println("cns= "+Arrays.toString(cns));
            //
            //for (int i = 0; i < nums.length; i++) {
            /**[重点难点]为什么这里必须从后向前?
            比如13和19,个位已经遍历完了,现在确保先遍历到19,后13,能让后面位大的排在后边
            * */
            for (int i = nums.length-1; i >=0; i--) {
                int digit = nums[i]/exp%10;
                buf[cns[digit]-1]=nums[i];

                System.out.println("i="+i+" nums[i]="+ nums[i]+" ,digit="+digit);
                System.out.println("  cnt[digit]="+cns[digit] +"  buf["+(cns[digit]) +"]="+ nums[i]);
                cns[digit]--;
            }
            exp *= 10;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = buf[i];
            }
            //nums =Arrays.copyOf(buf,nums.length);
            /*[易错]:nums现在指向新对象了,而不能改变原来nums的值!!!
             * 当你在方法中执行 nums = Arrays.copyOf(buf, nums.length); 时，实际上是将 buf 数组的内容复制到了一个新的数组中，
             * 并将新数组的引用赋给了 nums。这并不会改变原始的 nums 数组，只是让 nums 引用了一个新的数组对象。
             */
            //System.out.println("cnt"+Arrays.toString(cns));
            System.out.println(Arrays.toString(nums));
        }
        //System.out.println("fin"+Arrays.toString(nums));
    }

}
//[31, 21, 13, 26, 19]
//[19, 13, 26, 21, 31]
//cnt[0, 0, 2, 2, 3, 3, 3, 4, 4, 4]
//buf[21, 31, 13, 26, 19]
//cnt[0, 0, 2, 4, 5, 5, 5, 5, 5, 5]
//buf[13, 19, 21, 26, 31]
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/maximum-gap/solutions/498428/zui-da-jian-ju-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//i=4 nums[i]=31 ,digit=1
//  cnt[digit]=2  buf[2]=31
//i=3 nums[i]=21 ,digit=1
//  cnt[digit]=1  buf[1]=21
//i=2 nums[i]=19 ,digit=9
//  cnt[digit]=5  buf[5]=19
//i=1 nums[i]=26 ,digit=6
//  cnt[digit]=4  buf[4]=26
//i=0 nums[i]=13 ,digit=3
//  cnt[digit]=3  buf[3]=13
//cnt[0, 0, 2, 2, 3, 3, 3, 4, 4, 4]
//buf[21, 31, 13, 26, 19]
//i=4 nums[i]=19 ,digit=1
//  cnt[digit]=2  buf[2]=19
//i=3 nums[i]=26 ,digit=2
//  cnt[digit]=4  buf[4]=26
//i=2 nums[i]=13 ,digit=1
//  cnt[digit]=1  buf[1]=13
//i=1 nums[i]=31 ,digit=3
//  cnt[digit]=5  buf[5]=31
//i=0 nums[i]=21 ,digit=2
//  cnt[digit]=3  buf[3]=21
//cnt[0, 0, 2, 4, 5, 5, 5, 5, 5, 5]
//buf[13, 19, 21, 26, 31]
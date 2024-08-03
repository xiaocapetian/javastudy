package leetcode;

/**自己想的方法,从后往前填
 和标准答案一模一样,我真厉害!
 *
 */
public class l88 {
    /**
     * @param nums1  请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * @param m   nums1 m个有效位   nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3      最后要num1 = [1,2,2,3,5,6]
     * @param nums2
     * @param n   nums2 n个有效位
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int right = m+n-1; //这个负责写
        int cur2 = n-1; //这两个负责读
        int cur1 = m-1;
        while (cur1>=0||cur2>=0){
            if(cur2<0){
                nums1[right] = nums1[cur1];
                cur1--;
            }else if(cur1<0){
                nums1[right] = nums2[cur2];
                cur2--;
            }else {
                if(nums1[cur1]<nums2[cur2]){
                    nums1[right] = nums2[cur2];
                    cur2--;
                }else {
                    nums1[right] = nums1[cur1];
                    cur1--;
                }
            }
            right--;
        }
    }
}

package leetcode;

public class l88 {
    //自己想的方法,从后往前填
    //和标准答案一模一样,我真厉害!
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int right = m+n-1;//这个负责写
        int cur2 = n-1;//这两个负责读
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

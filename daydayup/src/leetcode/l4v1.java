package leetcode;

public class l4v1 {
    //基本呢抄答案的
    //时间复杂度O(log(m+n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 =nums1.length;
        int l2 =nums2.length;
        //欲求第(l1+l2)/2大的,或求(l1+l2)/2和(l1+l2)/2+1均
        //int k= (l1+l2)/2;
        /*这里k的定义要特别注意*/
        //k是指从start开始往后数几个
        int left = (l1+l2+1)/2;
        int right = (l1+l2+2)/2;
        return (find(nums1,nums2,0,0,l1-1,l2-1,left)+
                find(nums1,nums2,0,0,l1-1,l2-1,right))/2.0;
    }
    private int find(int[] nums1, int[] nums2,int start1,int start2,int end1,int end2,int k){
        int l1 =end1-start1+1;
        int l2 =end2-start2+1;
        /*这里有简化技巧👇,能保证如果有数组空了，一定是 len1 */
        if(l1>l2){return find(nums2,nums1,start2,start1,end2,end1,k);}
        if(l1==0){
            return nums2[start2+k-1];
        }
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        //现在要比两个数组的k/2-1哪个大了
        int cur1 = start1+Math.min(l1,k/2)-1;
        int cur2 = start2+Math.min(l2,k/2)-1;

        if(nums1[cur1]>nums2[cur2]){
            return find(nums1,nums2,start1,cur2+1, end1,end2,k-(cur2-start2+1));
        }else {
            return find(nums1,nums2,cur1+1,start2, end1,end2,k-(cur1-start1+1));
        }
    }
}

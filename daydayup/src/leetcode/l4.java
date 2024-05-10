package leetcode;

public class l4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //时间复杂度O(m+n)
        int l1 =nums1.length;
        int l2 =nums2.length;
        //欲求第(l1+l2)/2大的,或求(l1+l2)/2和(l1+l2)/2+1均
        int k= (l1+l2)/2;/*注意这里巧妙的符合了索引从0开始,0,1,2,3的时候,(2+2)/2=2正好和上一个求平均,
        0,1,2的时候(1+2)/2=1,消掉了后0.5所以也刚好*/
        int cur=0,cur1=0,cur2=0;
        int left = -1,right=-1;//重点看看这里是怎么做到的!!
        while (cur<=k){//因为是先用再++,故肯定是<=
            left = right;
            if(cur1<l1&&(cur2>=l2||nums1[cur1]<nums2[cur2])){ //因为这里比的是nums1[cur1]
                /*注意这里👆怎么写的,不仅要cur1<l1,而且要(两个之一)*/
                //cur2>=l2👆 =也要包括
                right=nums1[cur1]; //那自然要把cur1用到,再++了
                cur1++; //想清楚,先改right,后+1
            }else {
                right=nums2[cur2];
                cur2++;
            }
            cur++;
        }
        if((l1+l2)%2==0){
            return (left+right)/2.0;
        }else {
            return right;
        }

    }
}

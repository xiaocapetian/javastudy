package leetcode200;

import java.util.Arrays;

public class l215v1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};//现在[2, 2, 3, 1, 3, 4, 5, 5, 6]现在[2, 1, 3, 2, 3, 4, 5, 5, 6]
        findKthLargest(nums,2);
    }
    //力扣答案,感觉是奇技淫巧啊
    public static int findKthLargest(int[] _nums, int k) {
        int n = _nums.length;
        return quickselect(_nums, 0, n - 1, n - k);
    }
    static int quickselect(int[] nums, int shou, int wei, int k) {
        if (shou == wei) return nums[k];
        System.out.println("现在shou是nums["+shou+"] ="+nums[shou] +",  wei是nums["+wei+"] ="+nums[wei]);
        int left = shou - 1, right = wei + 1;//为什么要这样,因为这回是do{}先做一次再while
        while (left < right) {
            do {left++;
                //System.out.println("left左移,现在是nums["+left+"] ="+nums[left] );
            }while (nums[left] <nums[shou]);
            do {right--;
                //System.out.println("right右移,现在是nums["+right+"] ="+nums[right] );
            } while (nums[right] > nums[shou]);
            if (left < right){
                //System.out.println("left < right,交换" );
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;

            }
            System.out.println("现在"+ Arrays.toString(nums));
        }
        if (k <= right) {
            //System.out.println("k <= right, shou="+shou+",right="+right);
            System.out.println("排序前面,shou="+shou+"right-1="+(right-1));
            return quickselect(nums, shou, right, k);}
        else {
            //System.out.println("k > right, shou="+shou+",right="+right);
            System.out.println("排序后面,right+1="+(right+1)+"wei="+wei);
            return quickselect(nums, right + 1, wei, k);}
    }

}
/*现在shou是nums[0] =3wei是nums[5] =4
left左移,现在是nums[0] =3
right右移,现在是nums[5] =4
right右移,现在是nums[4] =6
right右移,现在是nums[3] =5
right右移,现在是nums[2] =1
left < right,交换
现在[1, 2, 3, 5, 6, 4]
left左移,现在是nums[1] =2
right右移,现在是nums[1] =2
right右移,现在是nums[0] =1
k > right, shou=0,right=0
现在shou是nums[1] =2wei是nums[5] =4
left左移,现在是nums[1] =2
right右移,现在是nums[5] =4
right右移,现在是nums[4] =6
right右移,现在是nums[3] =5
right右移,现在是nums[2] =3
right右移,现在是nums[1] =2
k > right, shou=1,right=1
现在shou是nums[2] =3wei是nums[5] =4
left左移,现在是nums[2] =3
right右移,现在是nums[5] =4
right右移,现在是nums[4] =6
right右移,现在是nums[3] =5
right右移,现在是nums[2] =3
k > right, shou=2,right=2
现在shou是nums[3] =5wei是nums[5] =4
left左移,现在是nums[3] =5
right右移,现在是nums[5] =4
left < right,交换
现在[1, 2, 3, 4, 6, 5]
left左移,现在是nums[4] =6
right右移,现在是nums[4] =6
right右移,现在是nums[3] =4
k > right, shou=3,right=3
现在shou是nums[4] =6wei是nums[5] =5
left左移,现在是nums[4] =6
right右移,现在是nums[5] =5
left < right,交换
现在[1, 2, 3, 4, 5, 6]
left左移,现在是nums[5] =6
right右移,现在是nums[4] =5
k <= right, shou=4,right=4*/

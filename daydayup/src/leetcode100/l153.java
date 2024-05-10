package leetcode100;

public class l153 {
    /*强记一下,不能比左边,只能比右边,想一下如果是单调的123*/
    //这题上面法就是不对,离谱,
    public int findMin1(int[] nums) {
//nums =[4,5,6,7,0,1,2]
        int left = 0;
        int right = nums.length-1;
        while (right>left){
            int mid = (left+right)/2;
            System.out.println("mid = "+mid+" nums[mid]="+nums[mid]
                    +", right= "+right+" nums[right]="+nums[right]
                    +", left ="+left+" nums[left]="+nums[left]);
            /*mid = 3 nums[mid]=7, right= 6 nums[right]=2, left =0 nums[left]=4
              mid = 5 nums[mid]=1, right= 6 nums[right]=2, left =4 nums[left]=0*/
            //如果到最后出现单调的012 就要右边去了,放弃了左边的最小值,所以不对
            if(nums[mid]>nums[left]){
                 left = mid+1;
            }else {
                right = mid;
            }
        }
        return nums[left];

    }
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("mid = "+mid+" nums[mid]="+nums[mid]
                    +"right= "+right+" nums[right]="+nums[right]
                    +", left ="+left+" nums[left]="+nums[left]);
            /*mid = 3 nums[mid]=7right= 6 nums[right]=2, left =0 nums[left]=4
mid = 5 nums[mid]=1right= 6 nums[right]=2, left =4 nums[left]=0
mid = 4 nums[mid]=0right= 5 nums[right]=1, left =4 nums[left]=0*/
            //如果到最后出现单调的012,R会左移动
            if (nums[mid] < nums[right]) {//这里if (nums[mid] < nums[right]) 或者if (nums[mid] <= nums[right])都可以
                right = mid;
            } else {//nums[mid] >= nums[right]
                left = mid + 1;
            }
        }
        return nums[left];
    }


}

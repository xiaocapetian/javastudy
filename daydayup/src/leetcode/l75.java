package leetcode;
//这个简单又快为啥不用呢
public class l75 {
    /**
     * @param nums 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *             我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     */
    public void sortColors(int[] nums) {

        int num0=0,num1=0,num2=0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){num0++;}
            if(nums[i]==1){num1++;}
            if(nums[i]==2){num2++;}
        }
        for(int i = 0;i<num0;i++){
            nums[i]=0;
        }
        for(int i = num0;i<num0+num1;i++){
            nums[i]=0;
        }
        for(int i = num0+num1;i<nums.length;i++){
            nums[i]=0;
        }
    }

}

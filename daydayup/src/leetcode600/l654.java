package leetcode600;

public class l654 {
    //自己写的自己冲!
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return create(nums,0,nums.length-1);

    }
    public TreeNode create(int[] nums,int begin,int end){
        //这两个缺一不可↓
        if(begin>end){return null;}
        if(begin==end){return new TreeNode(nums[begin]);}

        int maxItem = begin;
        for (int i = begin;i<=end;i++){
            if(nums[i]>nums[maxItem]){
                maxItem = i;
            }
        }
        //maxItem
        TreeNode root = new TreeNode(nums[maxItem]);
        root.left = create(nums,begin,maxItem-1);
        root.right = create(nums,maxItem+1,end);
        return root;

    }
}

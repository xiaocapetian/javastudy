package leetcode100;

public class l108 {
    //头脑放机灵一点  叫你构造平衡二叉树又没说要你一个一个放,不用你旋转什么的!
    //既然给你数组了,你就在数组中间取值然后冲呀!!
    /*给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
      高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。*/
    public TreeNode sortedArrayToBST(int[] nums) {

        int begin = 0;
        int end = nums.length-1;
        return create(nums,begin,end);
    }
    public TreeNode create(int[] nums,int begin,int end){
        if(begin>end)return null;
        if(begin==end)return new TreeNode(nums[begin]);
        int mid = (begin+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = create(nums,begin,mid-1);
        root.right = create(nums,mid+1,end);
        return root;
    }
}

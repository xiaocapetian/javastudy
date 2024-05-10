package leetcode100;
/*异或运算满足交换律，即A⊕B=B⊕A。
对于 10⊕12⊕10⊕9⊕12，可以使用交换律重排项：
10⊕12⊕10⊕9⊕12 = 10⊕10⊕12⊕12⊕9

由于任何数与自身进行异或操作的结果都是0，因此 10⊕10=0 和 12⊕12=0。
=0⊕0⊕0⊕9
而任何数与0进行异或操作的结果都是该数本身，所以 0⊕0=0。
=0⊕9=9
因此，结果为9。

* */
public class l136v1 {
    //要么出现一次要么出现两次
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;

    }
}

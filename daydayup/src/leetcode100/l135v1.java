package leetcode100;

public class l135v1 {
    //抄随想录的
    public int candy(int[] ratings) {
        int[] get = new int[ratings.length];
        get[0] = 1;
        //第一轮保证右边如果比左边好,一定比左边大1
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i-1]<ratings[i]){
                get[i] = get[i-1]+1;
            }else {
                //右如果没有左边好,置1
                get[i] =1;
            }
        }
        //System.out.println("第一轮之后"+ Arrays.toString(get));
        //第二轮保证如果左边比右边好,一定要左边比右边大
        for (int i = ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                //怎么保证左边比右边大?就是要么已经比右边大了,要么右+1
                get[i] = Math.max(get[i], get[i+1]+1);
            }
        }
        //System.out.println("第二轮之后"+ Arrays.toString(get));
        int ans = 0;
        for (int num : get) {
            ans += num;
        }
        return ans;
    }
}

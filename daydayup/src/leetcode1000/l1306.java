package leetcode1000;

/**
 * 很简单吧
 */
public class l1306 {
    /**
     * @param arr 这里有一个非负整数数组 arr，
     * @param start 你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
     * @return 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
     */
    public boolean canReach(int[] arr, int start) {

        return dfs(arr,start,new boolean[arr.length]);
    }

    private boolean dfs(int[] arr, int start,boolean[] visited) {
        visited[start]=true;
        if(arr[start]==0)return true;
        //arr[start]是可以跳的步数
        if(start-arr[start]>=0&&!visited[start-arr[start]]){
            //如果可以往左跳,且左没到过
            boolean res1= dfs(arr,start-arr[start],visited);
            if(res1)return true;
        }
        if(start+arr[start]<arr.length&&!visited[start+arr[start]]){
            //如果可以往右跳
            boolean res2= dfs(arr,start+arr[start],visited);
            if(res2)return true;
        }
        return false;
    }
}

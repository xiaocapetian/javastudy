package leetcode2000;

public class l2182v1 {
    public String repeatLimitedString(String s, int repeatLimit) {

        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        int right = 25;
        while (map[right] == 0) {
            right--;
        }
        StringBuilder sb = new StringBuilder();

        while (right>=0){
            int repeatcount = 0;
            while (repeatcount<repeatLimit&&map[right]>0){
                sb.append((char) (right+'a'));
                repeatcount++;
                map[right]--;
            }
            if(map[right]==0){
                //如果退出循环是因为right用完了
                right--;
                continue;
            }else {

                int left = right - 1;
                while (left>=0&&map[left]==0){
                    left--;
                }if(left>=0){
                    //如过退出循环是因为找到了下一个left
                    sb.append((char) (left+'a'));
                    map[left]--;
                }else{
                    //如果退出循环是因为没有left了
                    break;/*[易错]:如果没有次大了.就得break了*/
                }

            }

        }
        return sb.toString();
    }
}

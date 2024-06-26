package leetcode600;

public class l681 {
    /**  最近时刻
     *输入: "19:34"
     * 输出: "19:39"
     * 解释: 利用数字 1, 9, 3, 4 构造出来的最近时刻是 19:39，是 5 分钟之后。
     * 结果不是 19:33 因为这个时刻是 23 小时 59 分钟之后。
     *
     * @param time 给定一个形如 "HH:MM" 表示的时刻 time ，你可以认为给定的字符串一定是合法的。例如， "01:34" 和  "12:09" 是合法的，“1:34” 和 “12:9” 是不合法的。
     * @return 利用当前出现过的数字构造下一个距离当前时间最近的时刻。每个出现数字都可以被无限次使用。
     */
    public String nextClosestTime(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3));
        int t = h * 60 + m;
        //分别取h,m的十位和个位
        //如果小时的个位是 5，那么 (1 << (h % 10)) 将会得到二进制数 00100000。
        int mask = ~(1 << (h % 10) | 1 << (h / 10) | 1 << (m % 10) | 1 << (m / 10));
        //最后取反,凡是出现的数字将为1,
/*假设给定的时间是 "12:34"   得到二进制数 00000100 和 00000010 00010000 和 00001000   |可以 合并四个二进制数,得到二进制数 00011110 取反得到二进制数 11100001
            时间 "12:33"                                                                                               得到二进制数 11110001
* */
        for (int i = 0; i < 1440; i++) {
            t += 1;
            h = t/60 % 24;
            m = t%60;
            if ((((1 << (m % 10)) | (1 << (m / 10))) & mask) == 0 && (((1 << (h % 10)) | (1 << (h / 10))) & mask) == 0) {
                //按位与 & 如果给出的分钟的十位或各位出现了没出现过的数字,那位就会是1,那就和mask一与& 就成了1 那最终就不等于0
                //如果结果等于 0,则表示当前的分钟部分不包含已经出现过的数字。
                return String.format("%02d:%02d", h, m);
            }
        }
        return ""; // Handle case where no valid time is found
    }
}

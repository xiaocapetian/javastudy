package leetcode1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *我抄我抄原来这么简单啊!面试的时候把这个方法写出来应该就过了吧
 * 不至于像第一次v0那么尴尬了!!!!!
 */
public class l1233v1 {
    /**
     * 删除子文件夹
     * @param folder 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
     * @return 输出：["/a","/c/d","/c/f"]
     */
    public List<String> removeSubfolders(String[] folder) {

        Arrays.sort(folder);
        List<String> res = new ArrayList<String>();
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            judge(res,folder[i]);
        }
        return res;
    }

    private void judge(List<String> res , String s2) {
        String s1 = res.get(res.size() - 1);
        if (s1.length()>=s2.length()) {//👈速度优化
            //s2不可能是s1的子,直接接加
            res.add(s2);
            return;
        }
        if (s2.charAt(s1.length())!='/'){//👈速度优化
            res.add(s2);
            return;
        }
        if (!s2.substring(0,s1.length()).equals(s1)){//👈速度优化
            res.add(s2);
            return;
        }

/*//不用这样子一位一位的比,太慢了
 *        String[] s1split = s1.split("/");
 *         String[] s2split = s2.split("/");
 *         for(int i = 0 ; i < s1split.length ; i++){
 *             if(!s1split[i].equals(s2split[i])){
 *                 res.add(s2);
 *                 return;
 *             }
 *         }
 */
    }
}

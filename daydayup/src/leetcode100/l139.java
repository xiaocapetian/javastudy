package leetcode100;

import java.util.HashSet;
import java.util.List;

public class l139 {
    //s = "applepenapple", wordDict = ["apple", "pen"]
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] bp = new boolean[s.length()+1];
        bp[0] = true;
/*组合数先物品在背包,排列数先背包再物品*/
        for (int j = 1;j<=s.length();j++){  /* i 遍历目标字符串*///===🙂👇=== 为什么先遍历物品再遍历背包?画二维表啊!
            //===为什么====,上例子中,applepenapple最后一位不会为true,因为第一行pen的位置就不是true(没看到pen).那后面的apple也不能true了
             for(int i = 0;i<wordDict.size();i++){/* i 遍历字典*/
                 //什么时候能把bp[j]置成true?
                 if(j-wordDict.get(i).length()>=0   //大于0才能下一步啊
                         &&bp[j-wordDict.get(i).length()]   //画二维的表啊!//我现在看的是字典第i个能不能行,先看减掉i长度的bp[]位置能不能行
                         &&wordDict.get(i).equals(s.substring(j-wordDict.get(i).length(),j))//截取字符串=equal=字典里的元素
                         //
                 ){
                     bp[j] = true;
                     break;
                 }
//上三条满足置为true,否则,不做处理(必须先竖着刷一列再下一列,不做处理的意思就是保持上一行的结果)___这是一维的bp!!1
            }

        }



        return bp[s.length()];
    }
    /*这个看不懂*/
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] bp = new boolean[s.length()+1];
        bp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);
        for (int j = 1;j<=s.length();j++){
            for(int i = 0;i<j&&!bp[j];i++){
                if(set.contains(s.substring(i,j))&&bp[j]){
                    bp[j] = true;
                }
            }}

        return bp[s.length()];
    }
}

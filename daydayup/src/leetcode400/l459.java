package leetcode400;

public class l459 {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 1;i<=s.length()/2;i++){//长度为i的子串
            if(s.length()%i!=0)continue;
            boolean judgeQian = true;
            for(int j = i;j<s.length();j=j+i){//j为起始索引
                boolean judge = judge(s, i, j);
                //System.out.println("i="+i+"judge= "+judge);
                judgeQian = judgeQian&&judge(s,i,j);
            }

            if(judgeQian)return true;
        }
        return false;

    }
    public boolean judge(String s,int i,int j){//从j索引开始,的i个字符是否和从0开始的一致
        for (int index = 0;index<i;index++){
            if(index!=i&&s.charAt(j+index)!=s.charAt(index))return false;
        }
        return true;
    }
}

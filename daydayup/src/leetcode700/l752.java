package leetcode700;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 用广搜,成功了,就是写的比较慢,运行也比较慢,加油弄熟练!
 */
public class l752 {

    public int openLock(String[] deadends, String target) {

        Set<String> deadSet = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            deadSet.add(deadends[i]);
        }
        //StringBuilder sb = new StringBuilder();
        //sb.append("0000");
        //Queue<StringBuilder> queue=new LinkedList<>();queue.add(sb);
        //Queue<String> queue=new LinkedList<>();
        //queue.add("0000");
        char[] init = new char[4];
        for (int i = 0; i < init.length; i++) {
            init[i] = '0';
        }
        Queue<char[]> queue=new LinkedList<>();
        int count=0;
        /*[易错]最开始也可能不合法*/
        if(deadSet.contains(chararrtoStr(init)))return -1;
        queue.add(init);deadSet.add(chararrtoStr(init));
        while (!queue.isEmpty()){
            //             for (char[] chars : queue) {
            //     System.out.print(chararrtoStr(chars)+"  ");
            // }System.out.println("=====");

            int size = queue.size();
            for(int i = 0;i<size;i++){
                char[] poll = queue.poll();
                if(chararrtoStr(poll).equals(target))return count;
                for(int j = 0;j<4;j++){
                    if(poll[j]=='9'){
                        char[] small = poll.clone();
                        small[j] = '8';
                        char[] big = poll.clone();
                        big[j] = '0';
                        if(!deadSet.contains(chararrtoStr(small))){
                            queue.add(small);deadSet.add(chararrtoStr(small));
                        }
                        if(!deadSet.contains(chararrtoStr(big))){
                            queue.add(big);deadSet.add(chararrtoStr(big));
                        }
                    }else if(poll[j]=='0'){
                        char[] small = poll.clone();
                        small[j] = '9';
                        char[] big = poll.clone();
                        big[j] = '1';
                        if(!deadSet.contains(chararrtoStr(small))){
                            queue.add(small);deadSet.add(chararrtoStr(small));
                        }
                        if(!deadSet.contains(chararrtoStr(big))){
                            queue.add(big);deadSet.add(chararrtoStr(big));
                        }
                    }else {
                        char[] small = poll.clone();
                        small[j] = (char) (small[j]-'0'-1+'0');
                        /*[重难]这里small[j]-'0'-1+'0'  这么写挺有难度的啊~*/
                        char[] big = poll.clone();
                        big[j] = (char) (big[j]-'0'+1+'0');
                        if(!deadSet.contains(chararrtoStr(small))){
                            queue.add(small);deadSet.add(chararrtoStr(small));
                        }
                        if(!deadSet.contains(chararrtoStr(big))){
                            queue.add(big);deadSet.add(chararrtoStr(big));
                        }
                    }
                }
            }
            count++;
        }

        return -1;

    }
    private String chararrtoStr(char[] chararr){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chararr.length; i++) {
            sb.append(chararr[i]);
        }
        return sb.toString();
    }

}
/**
 private int dfs (StringBuilder now , String target,Set<String> deadSet ,int count){
 if(now.toString().equals(target))return count;
 if(deadSet.contains(now.toString()))return -1;
 for(int i = 0;i<4;i++){
 if(now.charAt(i)=='0'){
 now.replace(i,i+1,"1");
 dfs(now,target,deadSet,count++);
 now.replace(i,i+1,"9");
 dfs(now,target,deadSet,count++);
 } else if(now.charAt(i)=='9'){
 now.replace(i,i+1,"0");
 dfs(now,target,deadSet,count++);
 now.replace(i,i+1,"8");
 dfs(now,target,deadSet,count++);
 }else {
 now.replace(i,i+1,(char)(now.charAt(i)-'0'+1)+"");
 dfs(now,target,deadSet,count++);
 now.replace(i,i+1,(char)(now.charAt(i)-'0'-1)+"");
 dfs(now,target,deadSet,count++);
 }
 }
 return 1;
 }
 */
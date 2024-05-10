package leetcode200;

import java.util.*;

public class l207 {//l207和l210
    //这两个方法好理解,他们是广度优先!!想想二叉树的层序遍历类似啊
    /*递归深度优先,队列广度优先*/
    //看了答案自己写的,很慢👇
    //法一法二的区别在与键值对
    //法一存的是要想修键,需要哪些 值          150ms
    //法二是 修"键"之后, 哪些课(值)才可以修     8ms
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //建一个hash表,
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();
        //键 修"键"之前 , 值 需要学 值列表
        for (int[] prerequisite : prerequisites) {
            //学prerequisite[0]前先学prerequisite[1]
            ArrayList<Integer> list = hash.getOrDefault(prerequisite[0], new ArrayList<>());
            list.add(prerequisite[1]);
            hash.put(prerequisite[0],list);
        }
        //建一个列表,表示每门课有(还剩)多少先修课
        int[] arr = new int[numCourses];
        for (Map.Entry<Integer, ArrayList<Integer>> entry : hash.entrySet()) {
            arr[entry.getKey()] = entry.getValue().size();
        }
        //建一个队列
        Deque<Integer> deque =new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){//这个叫"入度"   入度=0说明可访问
                arr[i]=-1;
                deque.push(i);}
        }
        if (deque.size() == 0) {
            return false;
        }
        while (!deque.isEmpty()){
            int ke = deque.pop();//修了一门课
            /*为什么慢,应为这里里面有一个循环,每修完一个课,要遍历hash里每个元素看看值里有没有刚刚修的课*/
            //为什么会这样是因为法一存的是要想修键,需要哪些 值
            /*而法二呢,是修完一个课直接取map键种把值统一--了*/
            for (Map.Entry<Integer, ArrayList<Integer>> entry : hash.entrySet()) {
                if(entry.getValue().contains(ke)){
                    arr[entry.getKey()]--;
                    if(arr[entry.getKey()]==0){
                        arr[entry.getKey()]=-1;
                        deque.push(entry.getKey());
                    }
                }
            }
            //不要在这里判断了👇,直接在上面👆,--的时候判断减完.会不会到0,快一点
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i]==0){
//                    arr[i]=-1;
//                    deque.push(i);}
//            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=-1){return false;}
        }
        return true;
    }
    //
    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        //建一个hash表,
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();
        //现在这个存的是,修"键"之后, 哪些课(值)才可以修
        for (int[] prerequisite : prerequisites) {
            //学prerequisite[0]前先学prerequisite[1]
            ArrayList<Integer> list = hash.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            hash.put(prerequisite[1],list);
        }
        //建一个列表,表示每门课有(还剩)多少先修课
        int[] arr = new int[numCourses];
        for (Map.Entry<Integer, ArrayList<Integer>> entry : hash.entrySet()) {
            //arr[entry.getKey()] = entry.getValue().size();
            for (Integer ke : entry.getValue()) {
                arr[ke]++;
            }
        }
        //建一个队列
        Deque<Integer> deque =new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                arr[i]=-1;
                deque.push(i);}
        }
        //int count = deque.size();
        if (deque.size() == 0) {
            return false;
        }
        while (!deque.isEmpty()){
            int ke = deque.pop();//修了一门课
            if(hash.containsKey(ke)){
                for (Integer canStudyKe:hash.get(ke) ) {
                    arr[canStudyKe]--;
                    if(arr[canStudyKe]==0){
                        arr[canStudyKe]=-1;
                        deque.push(canStudyKe);
                    }
                }
            }


        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=-1){return false;}
        }
        return true;
    }


}

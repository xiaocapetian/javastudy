package leetcode;

import java.util.*;

public class l71 {
    public String simplifyPath(String path) {

        String[] patharr = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        //List<String> list = new ArrayList<>();
        for (String s : patharr) {
            if(s.equals("")||s.equals(".")){continue;}
            if(s.equals("..")){
                //if(!deque.isEmpty()){deque.pollLast();}
                deque.pollLast();//双端队列就算为空也可以poll
            }else {
                deque.add(s);
            }

        }
//        StringJoiner sj = new StringJoiner("/");
//
//
//        while (!deque.isEmpty()){
//            sj.add(deque.pollFirst());
//        }
//        return "/"+ sj;

        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty()) {
            sb.append('/');
        } else {
            while (!deque.isEmpty()) {
                sb.append('/');
                sb.append(deque.pollFirst());
            }
        }
        return sb.toString();


    }
    public String simplifyPath2(String path) {

        String[] patharr = path.split("/");
        //Deque<String> deque = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        for (String s : patharr) {
            if(s.equals("")||s.equals(".")){continue;}
            if(s.equals("..")){
                if(!list.isEmpty()){list.remove(list.size()-1);}
            }else {
                list.add(s);
            }

        }
        StringJoiner sj = new StringJoiner("/");

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sj.add(s);
        }
        return "/"+ sj;
    }
}

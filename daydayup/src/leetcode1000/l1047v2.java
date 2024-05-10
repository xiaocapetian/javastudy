package leetcode1000;

import java.util.ArrayDeque;
import java.util.Deque;

public class l1047v2 {
    //用deque模拟栈
    public String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (deque.isEmpty() || deque.peekLast() != s.charAt(i)) {
                deque.addLast(s.charAt(i));
            } else {
                deque.removeLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}

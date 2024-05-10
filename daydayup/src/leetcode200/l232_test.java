package leetcode200;

public class l232_test {
    public static void main(String[] args) {
        l232MyQueue l232MyQueue = new l232MyQueue();
        l232MyQueue.push(1);
        l232MyQueue.push(2);
        System.out.println(l232MyQueue.peek());
        System.out.println(l232MyQueue.pop());
        l232MyQueue.empty();
    }

}

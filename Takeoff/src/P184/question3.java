package P184;

public class question3 {
    //猴子吃桃子
    public static void main(String[] args) {
        System.out.println(monkeyPeach(1));
    }
    public static int monkeyPeach (int day){
        if(day<1||day>11){
            return -1;
        }else if(day == 10){
            return 1;
        }else {
            return (monkeyPeach(day+1)+1)*2;
        }
    }
}

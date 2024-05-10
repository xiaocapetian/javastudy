package P184;

public class question4 {
    //爬楼梯，每次爬一台阶or2阶
    public static void main(String[] args) {
        System.out.println(howmanystep(20));
    }
    public static int howmanystep(int loutishu){
        if (loutishu ==1)return 1;
        else if (loutishu ==2)return 2;//这里不能用2！！
        else return howmanystep(loutishu-1)+howmanystep(loutishu-2);
    }
}

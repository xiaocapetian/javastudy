package day36reflect.A02dynamicproxy.mydynamicproxy1;

public class tt {
    public static void main(String[] args) {
        BigStar bigStar = new BigStar("毛泽东");
        Star proxy = ProxyBigstartt.createproxy(bigStar);
//注意了,这个proxy的前面只能写star ,不能写ProxyBigstartt这个类


        String result = proxy.sing("只因你太美");
        System.out.println(result);

    }
}

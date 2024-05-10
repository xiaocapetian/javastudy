package P184;

import java.util.Arrays;

public class question1 {
    public static void main(String[] args) {
        GirlFriend gf1 = new GirlFriend("xiaoshishi",18,1.67);
        GirlFriend gf2 = new GirlFriend("xiaodd",19,1.72);
        GirlFriend gf3 = new GirlFriend("xiaoxx",19,1.60);
        GirlFriend gf4 = new GirlFriend("xiaodd1",17,1.72);
        GirlFriend gf5 = new GirlFriend("aa",19,1.60);
        GirlFriend[] arr = {gf1,gf2,gf3,gf4,gf5};

        //匿名内部类
/*        Arrays.sort(arr, new Comparator<GirlFriend>() {
            @Override
            public int compare(GirlFriend o1, GirlFriend o2) {
                double temp = o1.getAge()-o2.getAge();
                temp = temp == 0?o1.getHeight()-o2.getHeight():temp;
                temp = temp == 0?o1.getName().compareTo(o2.getName()):temp;
                if (temp>0){return 1;}
                else if (temp<0){return -1;}
                else {
                return 0;}
            }
        });*/

        //简化为lamda表达式
        Arrays.sort(arr, (o1, o2)-> {
                double temp = o1.getAge()-o2.getAge();
                temp = temp == 0?o1.getHeight()-o2.getHeight():temp;
                temp = temp == 0?o1.getName().compareTo(o2.getName()):temp;
                if (temp>0){return 1;}
                else if (temp<0){return -1;}
                else {
                    return 0;}
            }
        );


        System.out.println(Arrays.toString(arr));
    }
}

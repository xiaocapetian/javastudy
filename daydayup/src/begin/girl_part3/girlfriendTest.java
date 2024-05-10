package begin.girl_part3;

public class girlfriendTest {
    public static void main(String[] args) {
        girlfriend[] arr = new girlfriend[4];
        girlfriend gf1 = new girlfriend("cyy",18,"mengmei", "wangzhe");
        girlfriend gf2 = new girlfriend("wyy",19,"tianmei", "chnagge");
        girlfriend gf3 = new girlfriend("ayy",21,"mei", "study");
        girlfriend gf4 = new girlfriend("byy",20,"mei", "study");
        arr[0] = gf1;
        arr[1] = gf2;
        arr[2] = gf3;
        arr[3] = gf4;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i].getAge();
        }

        int avg = sum / arr.length;
        System.out.println(avg);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getAge()<=avg){

                System.out.println(arr[i].toString());
            }
        }

    }

}

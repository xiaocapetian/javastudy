package begin.student_part4;

public class studentTest {
    public static void main(String[] args) {
        student[] arr = new student[3];
        student st1 = new student(1,"maomao",65);
        student st2 = new student(2,"liushaoqi",60);
        student st3 = new student(3,"jiangqing",35);
        arr[0] = st1;
        arr[1] = st2;
        arr[2] = st3;

        student newst = new student(5,"maoxinyu",20);
        if(ifexist(arr,newst)){
           //已经存在
            System.out.println("exist");
        }else{
            if(ifEmpty(arr)==arr.length){
                //已经满了
                 arr = createNewarr(arr);
            }
            arr[arr.length-1] = newst;
            //arr[]
            showarr(arr);
        }
        //把stu4添加到数组当中
        //1.数组已经存满--- 只能创建一个新的数组，新数组的长度 = 老数组 + 1
        // 2.数组没有存满--- 直接添加
        deletestu(arr,6);
        //showarr(arr);
        deletestu(arr,3);
        //showarr(arr);
        Addold(arr,1);

    }
    public static boolean Addold(student[] arr,int id){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if(arr[i].getStudyNumber()==id){

                    arr[i].setAge(arr[i].getAge()+1);
                    System.out.println("add 1 year old");
                    showarr(arr);
                    return true;
                }
            }
        }
        System.out.println("no this id");
        showarr(arr);
        return false;
    }
    public static void showarr(student[] arr){
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != null) {
                System.out.println(arr[i].toString());
            }
        }
    }
    public static boolean deletestu(student[] arr,int id){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if(arr[i].getStudyNumber()==id){
                    arr[i] = null;
                    System.out.println("delete successfully");
                    showarr(arr);
                    return true;
                }
            }
        }
        System.out.println("no this id");
        showarr(arr);
        return false;
    }
    public static student[] createNewarr(student[] arr){
        student[] newarr = new student[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }
    public static boolean ifexist(student[] arr,student newstudent){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if(arr[i].getStudyNumber()==newstudent.getStudyNumber()){
                    //已存在
                    return true;
                }
            }
        }
        return false;
    }
    public static int ifEmpty(student[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null){
                count++;
            }
        }

        return count;
    }
}

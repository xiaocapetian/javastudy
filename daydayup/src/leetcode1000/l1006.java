package leetcode1000;

public class l1006 {
    public int clumsy(int n) {

        if(n==1)return 1;
        if(n==2)return 2*1;
        if(n==3)return 3*2/1;
        if(n==4)return 4*3/2+1;
        int yu = n%4;
        //yu==0 12*11/10+9-8*7/6+5-4*3/2+1
        //yu==1 (9*8/7+6)-()-1
        //==2 ()-()-2*1;
        //==4 (）-（）-3*2/1
        int res=0;
        res=n*(n-1)/(n-2)+(n-3);
        int shang=n/4;
        for(int i = 1;i<shang;i++){
            int s1=n-i*4;
            int s2=n-i*4-1;
            int s3=n-i*4-2;
            int s4=n-i*4-3;
            res+=-s1*s2/s3+s4;
        }
        if(yu==0){}
        if(yu==1){
            res+=-1;
        }
        if(yu==2){
            res+=-2*1;
        }
        if(yu==3){
            res+=-3*2/1;
        }
        return res;
    }
}

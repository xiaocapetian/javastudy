package leetcode800;

public class l860 {
    public boolean lemonadeChange(int[] bills) {

        int dollor5 = 0;
        int dollor10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5){
                dollor5++;}
            if(bills[i]==10){
                if(dollor5>0){dollor5--;}
                else{return false;}
                dollor10++;
            }
            if(bills[i]==20){
                if(dollor10>0){
                    dollor10--;
                    if(dollor5>0){
                        dollor5--;
                    }else {return false;}
                }else {
                    if(dollor5>=3){
                        dollor5=dollor10-3;
                    }else {return false;}
                }
            }
            //System.out.println("dollor5= "+dollor5+"dollor10= "+dollor10);
        }
return true;
    }
}

package begin.test_part1;

public class rolegame {
    public static void main(String[] args) {
        role r1 = new role("maomao",100);
        role r2 = new role("baobao",100);
        while(true){
            r1.attack(r2);
            if(r2.getBlood() == 0){
                System.out.println(r1.getName()+"ko"+r2.getName());
                break;
            }
            r2.attack(r1);
            if(r1.getBlood() == 0){
                System.out.println(r2.getName()+" ko "+r1.getName());
                break;
            }
        }
    }
}

package begin.test_role2_part2;

public class rolegame {
    public static void main(String[] args) {
        role r1 = new role("maomao",100,'N');
        role r2 = new role("baobao",100,'N');
        r1.showcharacter();
        System.out.println();
        r2.showcharacter();
        System.out.println();
        System.out.println("================");

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

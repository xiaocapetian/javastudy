package begin.test_role2_part2;

import java.util.Random;

public class role {
    private String name;
    private  int blood;
    private char gender;
    private String face;

    public role() {
    }

    public role(String name, int blood, char gender) {
        this.name = name;
        this.blood = blood;
        this.gender = gender;
        //this.face = face;
        setFace();
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }

    public void setFace() {
        Random r = new Random();

        if(this.gender=='N'){
            int faceint = r.nextInt(boyface.length);
            this.face = boyface[faceint];
        }else if(this.gender=='G'){
            int faceint = r.nextInt(girlface.length);
            this.face = girlface[faceint];
        }else {
            this.face = "ugly";
        }

    }

    String[] boyface = {"handsome","stupid","shameless"};
    String[] girlface = {"enchanting","beautiful","ugly"};


    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return blood
     */
    public int getBlood() {
        return blood;
    }

    /**
     * 设置
     * @param blood
     */
    public void setBlood(int blood) {
        this.blood = blood;
    }

    public String toString() {
        return "role{name = " + name + ", blood = " + blood + "}";
    }
    public void attack(role roleattacked){
        //随机生成一个伤害
        Random r = new Random();
        int hurt = r.nextInt(20)+1;
        //修改一下挨揍的人的血量
        int remainblood = roleattacked.getBlood() - hurt;
        remainblood = remainblood < 0 ? 0 : remainblood; //用这句话简单写了小于0的就是0
        roleattacked.setBlood(remainblood);
        //System.out.println(this.name+"attcck"+roleattacked.name+"and caused"+"100"+"damage");
        System.out.println(this.getName()+" attcck "+roleattacked.getName()+" and caused "+hurt+
                " damage,and now "+roleattacked.getName()+" remain "+ remainblood);
    }
    public  void showcharacter(){
        System.out.printf("name is %s ta is a %s %s",this.name,this.face,this.gender);
    }
}

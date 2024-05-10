package begin.test_part1;

import java.util.Random;

public class role {
    private String name;
    private  int blood;

    public role() {
    }

    public role(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

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
}

package begin.student_part4;

public class student {
    private int studyNumber;
    private String name;
    private int age;

    public student() {
    }

    public student(int studyNumber, String name, int age) {
        this.studyNumber = studyNumber;
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return studyNumber
     */
    public int getStudyNumber() {
        return studyNumber;
    }

    /**
     * 设置
     * @param studyNumber
     */
    public void setStudyNumber(int studyNumber) {
        this.studyNumber = studyNumber;
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
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "student{studyNumber = " + studyNumber + ", name = " + name + ", age = " + age + "}";
    }
}

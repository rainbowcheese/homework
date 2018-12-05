package Stream;

public class WuJiang {
    private String name;
    private String sex;
    private String location;
    private int birth;
    private int death;
    private int power;
    private int num;

    @Override
    public String toString() {
        return "WuJiang{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", death=" + death +
                ", power=" + power +
                '}';
    }

    public WuJiang(int num, String name, String location, String sex, int birth, int death, int power ) {
        this.num = num;
        this.name = name;
        this.location = location;
        this.sex = sex;
        this.birth = birth;
        this.death = death;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
